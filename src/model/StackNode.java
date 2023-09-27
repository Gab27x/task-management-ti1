package model;
public class StackNode<T> {

    StackNode<T> top;
    StackNode<T> bottom;
    T content;

    public StackNode(T content){
        this.top=null;
        this.bottom=null;
        this.content=content;
    }

    public void setTop(StackNode<T> node){
        this.top=node;
    }

    public void setBottom(StackNode<T> node){
        this.bottom=node;
    }

    public StackNode<T> getTop(){
        return this.top;
    }

    public StackNode<T> getBottom(){
        return this.bottom;
    }

    public T getContent(){
        return this.content;
    }

    public void setContent(T content){
        this.content=content;
    }



}
