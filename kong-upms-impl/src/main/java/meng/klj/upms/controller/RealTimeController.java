package meng.klj.upms.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/sse")
@Api(tags = {"实时数据推送"})
@Slf4j
public class RealTimeController {

    // 用于保存每个请求对应的 SseEmitter
     private Map<String, Result> sseEmitterMap = new ConcurrentHashMap<>();


     @GetMapping("/start")
     public SseEmitter testSseEmitter(String clientId) {
         // 默认30秒超时,设置为0L则永不超时
         SseEmitter sseEmitter = new SseEmitter(0L);
         sseEmitterMap.put(clientId, new Result(clientId, System.currentTimeMillis(), sseEmitter));
         return sseEmitter;
     }

    /**
       * 向SseEmitter对象发送数据
       * @param clientId
       * @return
      */
     @GetMapping("/send")
     public String setSseEmitter(String clientId) {
         try {
                 Result result = sseEmitterMap.get(clientId);
                 if (result != null && result.sseEmitter != null) {
                         long timestamp = System.currentTimeMillis();
                         result.sseEmitter.send(timestamp);
                     }
             } catch (IOException e) {
                 log.error("IOException!", e);
                 return "error";
             }

         return "Succeed!";
     }

    /**
   * 将SseEmitter对象设置成完成
     *
      * @param clientId
     * @return
      */
     @GetMapping("/end")
     public String completeSseEmitter(String clientId) {
         Result result = sseEmitterMap.get(clientId);
         if (result != null) {
                sseEmitterMap.remove(clientId);
                 result.sseEmitter.complete();
             }
        return "Succeed!";
     }




    private class Result {
         public String clientId;
         public long timestamp;
         public SseEmitter sseEmitter;
         public Result(String clientId, long timestamp, SseEmitter sseEmitter) {
                         this.clientId = clientId;
                         this.timestamp = timestamp;
                         this.sseEmitter = sseEmitter;
                     }
     }
}
