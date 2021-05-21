package meng.klj.common.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.StringBuilderWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class FileRead {
    public static void main(String[] args) throws IOException {
        Map<String, String> resultMap = new HashMap<>();
        File fileDirectory = new File("C:\\Users\\WHRDD-PC11\\Desktop\\apis");
        String[] matchedFileSuffix = new String[]{"js"};
        List<File> fileIterator = iteratorEffectiveFile(fileDirectory, matchedFileSuffix);
        if (fileIterator == null || fileIterator.size() == 0) return;

        fileIterator.forEach(f -> {
            String fName = f.getName();
            InputStreamReader in = null;
            try {
                FileInputStream fileInputStream = new FileInputStream(f);
                in = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                StringBuilderWriter out = new StringBuilderWriter();
                char[] buffer = new char[1024];
                int n;
                while (-1 != (n = in.read(buffer))) {
                    out.write(buffer, 0, n);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (final IOException ioe) {
                }
            }
            String s = null;
            try {
                s = FileUtils.readFileToString(f, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (s == null || s.equals("")) return;
            //清洗
            String finalStr = s.split("=")[1].replace(";", "").replace("`", "\"");
            JSONObject jb = null;
            try {
                jb = (JSONObject) JSON.parse(finalStr);
            } catch (Exception e) {
                System.out.println(String.format("文件： %s 解析错误", fName));
            }
            if (jb != null)
                resultMap.putAll(jb.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> ((JSONObject) e.getValue()).getString("action"))));

        });
        FileUtils.write(new File("C:\\Users\\WHRDD-PC11\\Desktop\\apis\\map.json"), JSON.toJSONString(resultMap));
    }

    private static List<File> iteratorEffectiveFile(File rootFile, String[] matchedFileSuffix) {
        ArrayList<File> files = new ArrayList<>();
        boolean directory = rootFile.isDirectory();
        if (!directory) {
            files.add(rootFile);
            return files;
        }

        File[] sonFiles = rootFile.listFiles();
        if (sonFiles == null || sonFiles.length == 0) return files;

        Arrays.stream(sonFiles).forEach(f -> {
            boolean directoryFlag = f.isDirectory();
            if (directoryFlag) {
                List<File> sonDirectoryFiles = iteratorEffectiveFile(f, matchedFileSuffix);
                if (sonDirectoryFiles != null && sonDirectoryFiles.size() > 0) files.addAll(sonDirectoryFiles);
            } else {
                String fName = f.getName();
                boolean present = Arrays.stream(matchedFileSuffix).filter(fName::endsWith).findAny().isPresent();
                if (present) files.add(f);
            }
        });

        return files;
    }

    //private void
}
