package gof.behavior.memento;

/**
 * Normal Class
 */
public class Originator {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Memento saveToMemento(){
        return new Memento(data);
    }

    private void loadMemento(Memento m){
        this.data = m.getData();
    }

    static class Memento{
        private String data;

        public Memento(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }
}
