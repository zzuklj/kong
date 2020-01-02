package meng.klj.common.algorithms.datastructures;

import java.util.Objects;
import java.util.Random;

public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {

    private int modifications = 0;

    protected static final Random RANDOM = new Random();

    protected Node<T> root = null;
    protected int size = 0;
    protected INodeCreator<T> creator =null;

    public enum DepthFirstSearchOrder{
        inOrder, preOrder, postOrder
    }

    public BinarySearchTree() {
        this.creator = new INodeCreator<T>() {
            @Override
            public Node<T> create(T id, Node parent) {
                return new Node<>(id, parent);
            }
        };
    }

    public BinarySearchTree(INodeCreator<T> creator) {
        this.creator = creator;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean add(T value) {
        Node<T> node = addValue(value);
        return (node != null);
    }

    protected Node<T> addValue(T value){
        Node<T> newNode = creator.create(value, null);

        if(newNode == null){
            root = newNode;
            size ++;
            return newNode;
        }

        Node<T> node = root;
        while (node != null){
            //less or equal, go left
            if(newNode.id.compareTo(node.id) <= 0){
                if(node.lesser == null){
                    node.lesser = newNode;
                    newNode.parent = node;
                    size ++;
                    return newNode;
                }
                node = node.lesser;
            }else{
                if(node.greater == null){
                    node.greater = newNode;
                    newNode.parent = node;
                    size ++;
                    return newNode;
                }
                node = node.greater;
            }
        }
        return newNode;
    }

    @Override
    public T remove(T value) {

        return null;
    }

    protected Node removeValue(T value){
        Node<T> node = getNode(value);
        if(node != null) node = removeNode(node);
        return node;
    }

    protected Node removeNode(Node<T> node){
        if(node != null){
            Node<T> replacementNode = getReplacementNode(node);

        }
        return null;
    }

    protected Node getReplacementNode(Node node){
        Node replacementNode = null;
        if(node.greater != null && node.lesser != null){
            if(modifications % 2 != 0){
                replacementNode = getGreatest(node);
                if(replacementNode == null){
                    replacementNode = node.lesser;
                }
            }else{
                replacementNode = getLeast(node);
                if(replacementNode == null){
                    replacementNode = node.greater;
                }
            }
            modifications ++;
        }else if(node.greater != null){
            replacementNode = node.greater;
        }else if(node.lesser != null){
            replacementNode = node.lesser;
        }
        return replacementNode;
    }

    protected void replaceNodeWithNode(Node<T> nodeToRemoved, Node<T> replacementNode){
        if(replacementNode != null){
            Node<T> replacementNodeLesser = replacementNode.lesser;
            Node<T> replacementNodeGreater = replacementNode.greater;

            Node<T> nodeToRemovedLesser = nodeToRemoved.lesser;
            if(nodeToRemovedLesser != null && nodeToRemovedLesser != replacementNode){
                replacementNode.lesser = nodeToRemovedLesser;
                nodeToRemovedLesser.parent = replacementNode;
            }

            Node<T> nodeToRemovedGreater = nodeToRemoved.greater;
            if(nodeToRemovedGreater != null && nodeToRemovedGreater != replacementNode){
                replacementNode.greater = nodeToRemovedGreater;
                nodeToRemovedGreater.parent = replacementNode;
            }

            Node<T> replacementNodeParent = replacementNode.parent;
            if(replacementNodeParent != null && replacementNodeParent != nodeToRemoved){

            }

        }


    }

    protected Node getGreatest(Node startNode){
        if(startNode == null){
            return null;
        }

        Node greatest = startNode.greater;
        while (greatest != null
                && greatest.id != null
                && greatest.greater != null
                && greatest.greater.id != null ){
                greatest = greatest.greater;
        }
        return greatest;
    }

    protected Node getLeast(Node startNode){
        if(startNode == null){
            return null;
        }

        Node lesser = startNode.lesser;
        while(lesser != null
                && lesser.id != null
                && lesser.lesser != null
                && lesser.lesser.id != null){
            lesser = lesser.lesser;
        }

        return lesser;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T value) {
        Node<T> node = getNode(value);
        return (node != null);
    }

    protected Node<T> getNode(T value){
        Node<T> node = root;
        while(node != null && node.id != null){
            int c = value.compareTo(node.id);
            switch (c){
                case -1:
                    node = node.lesser;
                    break;
                case 0:
                    return node;
                case 1:
                    node = node.greater;
            }
        }
        return null;
    }

    @Override
    public boolean validate(T value) {
        return false;
    }






    protected static class Node<T>{
        protected T id = null;
        protected Node<T> parent = null;
        protected Node<T> lesser = null;
        protected Node<T> greater = null;

        public Node(T id, Node<T> parent) {
            this.id = id;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "id=" + id + " parent=" + ((parent != null) ? parent.id : "NULL") + " lesser="
                    + ((lesser != null) ? lesser.id : "NULL") + " greater=" + ((greater != null) ? greater.id : "NULL");
        }
    }

    protected interface INodeCreator<T>{
        Node<T> create(T id, Node parent);
    }
}
