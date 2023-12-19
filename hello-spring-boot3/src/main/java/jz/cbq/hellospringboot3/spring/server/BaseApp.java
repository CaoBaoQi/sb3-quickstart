package jz.cbq.hellospringboot3.spring.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * BaseApp
 *
 * @author caobaoqi
 */
@Slf4j
public class BaseApp implements ApplicationListener<WebServerInitializedEvent> {
    private static Integer port;

    /**
     * 当应用程序事件为 WebServerInitializedEvent 事件时调用的方法。
     */
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        BaseApp.port = event.getWebServer().getPort();
    }

    /**
     * 运行应用程序并返回可配置的应用上下文。
     *
     * @param primarySource 主要类
     * @param args          参数
     * @return 可配置的应用上下文
     */
    public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
        return run(new Class[]{primarySource}, args);
    }

    /**
     * 运行应用程序并返回可配置的应用上下文。
     *
     * @param primarySources 主要类数组
     * @param args           参数
     * @return 可配置的应用上下文
     */
    public static ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(primarySources, args);
        printRunningAt(BaseApp.port);
        return context;
    }

    /**
     * 打印正在运行的服务器地址。
     *
     * @param port 服务器端口
     */
    protected static void printRunningAt(Integer port) {
        if (port == null) {
            log.warn("Server port not initialized.");
            return;
        }

        StringBuilder msg = new StringBuilder("\nServer running at:(CaoBaoQi)\n");
        msg.append(" > Local  : http://localhost:").append(port).append("\n");

        List<String> ipList = getLocalIpList();
        for (String ip : ipList) {
            msg.append(" > Network: http://").append(ip).append(":").append(port).append("\n");
        }
        System.out.println(msg);
    }

    /**
     * 获取本地 IP 列表。
     *
     * @return 本地 IP 列表
     */
    private static List<String> getLocalIpList() {
        List<String> ipList = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
                    continue;
                }

                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress ip = addresses.nextElement();
                    if (ip instanceof Inet4Address) {
                        ipList.add(ip.getHostAddress());
                    }
                }
            }
        } catch (Exception e) {
            log.error("Error getting local IP list: " + e.getMessage());
        }
        return ipList;
    }

}
