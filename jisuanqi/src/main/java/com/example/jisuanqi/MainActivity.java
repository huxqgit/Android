package com.example.jisuanqi;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    String s1, s2, s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn10).setOnClickListener(this);
        findViewById(R.id.btn11).setOnClickListener(this);
        findViewById(R.id.btn12).setOnClickListener(this);
        findViewById(R.id.btn13).setOnClickListener(this);
        findViewById(R.id.btn14).setOnClickListener(this);
        findViewById(R.id.btn15).setOnClickListener(this);
        findViewById(R.id.btn16).setOnClickListener(this);
        findViewById(R.id.btn17).setOnClickListener(this);
        findViewById(R.id.btn20).setOnClickListener(this);
        findViewById(R.id.btn30).setOnClickListener(this);

        tv = (TextView)findViewById(R.id.t1);//获取textview组件



    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(MainActivity.this, "您按下了按钮", Toast.LENGTH_SHORT).show();
        Button btn=(Button)v;
        String input=btn.getText().toString();

        String oldEt = tv.getText().toString();
        String newEt = "";

        //tv.setText(oldEt + input);

        boolean isFu = false;
        if(input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals(".")){
            if(oldEt.length() <= 0){
                oldEt = "0" + input;
                s1 = "0";
                tv.setText(oldEt);
                return;
            }
            else{
                String endStr = oldEt.substring(oldEt.length() - 1, oldEt.length());
                if(endStr.equals("+") || endStr.equals("-") || endStr.equals("*") || endStr.equals("/") || endStr.equals(".") ){
                    String tmpStr = oldEt.substring(0, oldEt.length() - 1) + input;
                    tv.setText(tmpStr);
                    return;
                }
            }
        }

        if(input.equals("=") && oldEt.length() <= 0){
            return;
        }

        if(input.equals("=")){
            //将含有乘除法的算式转换为只含有加减
            String str = chang1(oldEt);
            while(str.contains("*") || str.contains("/")){
                str = chang1(str);
            }

            str = getRet(str);
            while(str.contains("+") || str.contains("-")){
                str = getRet(str);
            }

            tv.setText(oldEt + "=" + str);
            return;
        }

        switch(input) {
            case "1":
                newEt = oldEt + input;
                break;
            case "2":
                newEt = oldEt + input;
                break;
            case "3":
                newEt = oldEt + input;
                break;
            case "4":
                newEt = oldEt + input;
                break;
            case "5":
                newEt = oldEt + input;
                break;
            case "6":
                newEt = oldEt + input;
                break;
            case "7":
                newEt = oldEt + input;
                break;
            case "8":
                newEt = oldEt + input;
                break;
            case "9":
                newEt = oldEt + input;
                break;
            case "0":
                newEt = oldEt + input;
                break;
            case ".":
                if(isFu){
                    newEt = oldEt.substring(0, oldEt.length() - 1) + input;
                }
                else {
                    newEt = oldEt + input;
                }
                break;
            case "+":
                if(isFu){
                    newEt = oldEt.substring(0, oldEt.length() - 1) + input;
                }
                else {
                    newEt = oldEt + input;
                }
                break;
            case "-":
                if(isFu){
                    newEt = oldEt.substring(0, oldEt.length() - 1) + input;
                }
                else {
                    newEt = oldEt + input;
                }
                break;
            case "*":
                if(isFu){
                    newEt = oldEt.substring(0, oldEt.length() - 1) + input;
                }
                else {
                    newEt = oldEt + input;
                }
                break;
            case "/":
                if(isFu){
                    newEt = oldEt.substring(0, oldEt.length() - 1) + input;
                }
                else {
                    newEt = oldEt + input;
                }
                break;
            case "(":
                newEt = oldEt + input;
                break;
            case ")":
                newEt = oldEt + input;
                break;
            case "=":
                newEt = oldEt + input;
                break;
            case "AC":
                newEt = "";
                break;
            case "Del":
                if(oldEt.length() > 0){
                    newEt = oldEt.substring(0,oldEt.length()-1);
                }
                break;
        }

        tv.setText(newEt);

    }

    private String chang1(String oldEt){
        String str, str1 = "", str2 = "", str3 = "";
        str = oldEt;
        int n1 = 0, n2 = 0;
        char[] oldArray = oldEt.toCharArray();
        for(int i = 0; i < oldEt.length(); i++){
            if(oldArray[i] == '*' || oldArray[i] == '/'){

                //获取*号之前的数字串
                for(int j = i-1; j >= 0; j--){
                    n1 = j;
                    if( (oldArray[j] >= '0' && oldArray[j] <= '9') || oldArray[j] == '.') {
                        n1--;
                    }else {
                        break;
                    }
                }
                str1 = oldEt.substring(n1+1, i);

                //获取*号之后的数字串
                for(int j = i+1; j < oldEt.length(); j++){
                    n2 = j;
                    if((oldArray[j] >= '0' && oldArray[j] <= '9') || oldArray[j] == '.') {
                        n2++;
                    }else {
                        break;
                    }
                }
                str2 = oldEt.substring(i+1, n2);

                double ret = 0f;
                if(oldArray[i] == '*'){
                    ret = Double.parseDouble(str1) * Double.parseDouble(str2);
                }
                else if(oldArray[i] == '/') {
                    ret = Double.parseDouble(str1) / Double.parseDouble(str2);
                }

                if(n1 == 0){
                    str3 = "" + ret;
                }else{
                    str3 = oldEt.substring(0, n1+1) + ret;
                }

                if(n2 < oldEt.length()){
                    str3 = str3 + oldEt.substring(n2, oldEt.length());
                }

                return str3;
            }
        }

        return str;
    }

    private String getRet(String str){
        int n1, n2;
        String str1, str2, str3;
        str3 = str;
        char[] arr = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            if(arr[i] == '+' || arr[i] == '-'){
                n1 = i;
                n2 = i+1;
                for(int j = i+1; j < str.length(); j++){
                    n2 = j;
                    if((arr[j] >= '0' && arr[j] <= '9') || arr[j] == '.') {
                        n2++;
                    }
                    else{
                        break;
                    }
                }

                str1 = str.substring(0, n1);
                str2 = str.substring(i+1, n2);

                double ret = 0f;
                if(arr[i] == '+'){
                    ret = Double.parseDouble(str1) + Double.parseDouble(str2);
                }
                else if(arr[i] == '-') {
                    ret = Double.parseDouble(str1) - Double.parseDouble(str2);
                }

                if(n2 < str.length()){
                    str3 = ret + str.substring(n2, str.length());
                }
                else{
                    str3 = ret + "";
                }

                System.out.println("str3:" + str3);

                return str3;
            }
        }

        return str3;
    }

}