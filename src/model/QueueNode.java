public class QueueNode<T> {
    // Double linked list
        QueueNode<T> next;
        QueueNode<T> previous;
        T content;

        public QueueNode(T content){
            this.content = content;
        }

        public void setNext(QueueNode<T> node){
            this.next = node;
        }

        public void setPrevious(QueueNode<T> node){
            this.previous = node;
        }

        public QueueNode<T> getNext(){
            return this.next;
        }

        public QueueNode<T> getPrevious(){
            return this.previous;
        }

        public T getContent(){
            return this.content;
        }

        public void setContent(T content){
            this.content = content;
        }


}
