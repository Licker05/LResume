package com.LResume.test;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
class Util{
    static StringBuilder sb;
    static List<String> list = new ArrayList<String>();
    public static List<String> fn(String s,int len){
        sb = new StringBuilder();
        emu(s,len);
        return list;
    }

    public static void emu(String s,int len){
        if(sb.length() >= len) {
            list.add(sb.toString());
        }
        else {
            for(int i = 0; i < s.length(); i++){
                sb.append(s.charAt(i));
                emu(s,len);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
class MessageQueue{
    List<String> mq = new ArrayList<>();
    public synchronized void setMq(String s){
        mq.add(s);
        this.notify();
    }
    public synchronized void getMq(){
        if(mq.isEmpty()){
            try {
                this.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            String returnS = mq.get(0);
            System.out.println("测试密码: "+returnS);
            mq.remove(0);
        }
    }
}
class Crack extends Thread{
    private String wantString;
    private MessageQueue messageQueue;
    public Crack(MessageQueue messageQueue,String wantString){
        this.messageQueue=messageQueue;
        this.wantString=wantString;
    }
    @Override
    public void run(){
        List<String> newString = Util.fn("0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",3);
        for(String str : newString){
            messageQueue.setMq(str);
            if(str.equals(wantString)){
                break;
            }
        }
    }
}
class CrackHistory extends Thread{
    public MessageQueue messageQueue;
    public CrackHistory(MessageQueue messageQueue){
        this.messageQueue = messageQueue;
    }
    @Override
    public void run(){
        while(true){
            messageQueue.getMq();
        }
    }
}
class ThreadRun extends Thread{
    @Override
    public void run(){
        while(true){

        }
    }
}
public class test {
    public static String romdomString;
    public static void main(String[] args){
        try{
            romdomString = UUID.randomUUID().toString().substring(0,3);
            System.out.println("需要破解的密码为:"+romdomString);
            MessageQueue messageQueue = new MessageQueue();
            Crack crack = new Crack(messageQueue,romdomString);
            CrackHistory crackHistory=new CrackHistory(messageQueue);
            crackHistory.setDaemon(true);
            new ThreadRun().start();
            crack.start();
            crackHistory.start();
        }catch (Exception e){
           e.printStackTrace();
        }

    }
}
