package gof.behavior.observer.example1;

/**
 * Created by Gal on 8/25/2017.
 */
abstract class Observer {
    protected Subject subject;

    protected Observer(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }


    abstract void update();
}
