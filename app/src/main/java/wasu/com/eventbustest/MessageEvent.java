package wasu.com.eventbustest;

/**
 * Created by Administrator on 2017/5/16.
 */

public class MessageEvent {
    private String msg;

    public MessageEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
