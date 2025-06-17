package com.example.playroom.Exception;

public class PRNotFoundException extends Exception{

    public PRNotFoundException(String msg){
        super(msg);
    }
    //インスタンス化した際に、エラーメッセージを受け取るためのコンストラクタを定義します。
}
