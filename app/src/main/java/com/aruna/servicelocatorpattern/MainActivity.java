package com.aruna.servicelocatorpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Car car = new Car();
        car.start();

        serData();
    }

    private void serData() {
        String data = "Alternatives to dependency injection</BR></BR>" +
                "An alternative to dependency injection is using a service locator. The service locator design pattern also improves decoupling of classes from concrete dependencies. You create a class known as the service locator that creates and stores dependencies and then provides those dependencies on demand.</br></br></br></br>" +
                "</br>" +
                "class ServiceLocator {</br>" +
                "</br>" +
                "    private static ServiceLocator instance = null;</br>" +
                "</br>" +
                "    private ServiceLocator() {}</br>" +
                "</br>" +
                "    public static ServiceLocator getInstance() {</br>" +
                "        if (instance == null) {</br>" +
                "            synchronized(ServiceLocator.class) {</br>" +
                "                instance = new ServiceLocator();</br>" +
                "            }</br>" +
                "        }</br>" +
                "        return instance;</br>" +
                "    }</br>" +
                "</br>" +
                "    public Engine getEngine() {</br>" +
                "        return new Engine();</br>" +
                "    }</br>" +
                "}</br>" +
                "</br>" +
                "class Car {</br>" +
                "</br>" +
                "    private Engine engine = ServiceLocator.getInstance().getEngine();</br>" +
                "</br>" +
                "    public void start() {</br>" +
                "        engine.start();</br>" +
                "    }</br>" +
                "}</br>" +
                "</br>" +
                "class MyApp {</br>" +
                "    public static void main(String[] args) {</br>" +
                "        Car car = new Car();</br>" +
                "        car.start();</br>" +
                "    }</br>" +
                "}";

        WebView webview = (WebView)this.findViewById(R.id.WebView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadData(data, "text/html; charset=utf-8", "UTF-8");
    }
}