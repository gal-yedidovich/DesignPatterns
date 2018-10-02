package architectual_patterns.mvc.example2;

public abstract class View {
    private int width, height;
    private OnClickListener listener;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public OnClickListener getListener() {
        return listener;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public abstract void presentView();

    //interface for click event
    public interface OnClickListener {
        void onClick(View v);
    }
}
