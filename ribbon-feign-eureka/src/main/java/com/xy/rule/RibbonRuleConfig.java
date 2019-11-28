package com.xy.rule;

import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 陆明宇 on 2019/11/28.
 * Ribbon负载均衡策略
 * 【Ribbon的负载均衡策略】
 *   (1)RandomRule （随机策略）：
 *      随机选择 Server
 *   (2)RoundRobinRule （轮训策略）：
 *      按顺序循环选择 Server
 *   (3)RetryRule （重试策略）：
 *      在一个配置时问段内当选择 Server 不成功，
 *      则一直尝试选择一个可用的 Server
 *   (4)BestAvailableRule （最低并发策略）：
 *      逐个考察 Server，
 *      如果 Server 断路器打开，则忽略，
 *      再选择其中并发连接最低的 Server
 *   (5)AvailabilityFilteringRule （可用过滤策略）：
 *      过滤掉一直连接失败并被标记为 circuit tripped 的 Server，
 *      过滤掉那些高并发连接的 Server（active connections 超过配置的网值）
 *   (6)ResponseTimeWeightedRule （响应时间加权策略）：
 *      根据 Server 的响应时间分配权重。
 *      响应时间越长，权重越低，被选择到的概率就越低；
 *      响应时间越短，权重越高，被选择到的概率就越高。
 *      这个策略很贴切，综合了各种因素，如：网络、磁盘、IO等，
 *      这些因素直接影响着响应时间
 *   (7)ZoneAvoidanceRule （区域权衡策略）：
 *      综合判断 Server 所在区域的性能和 Server 的可用性轮询选择 Server，
 *      并且判定一个 AWS Zone 的运行性能是否可用，剔除不可用的 Zone 中的所有 Server
 * @author 陆明宇
 * @version 1.0
 * @description RibbonRuleConfig
 * @modify 陆明宇
 * @since 10:45
 */
@Configuration
public class RibbonRuleConfig {

    @Value("${rule.chosen}")
    private String rule;

    /**
     * Ribbon的负载均衡策略
     * @return IRule
     */
    @Bean
    public IRule ribbonRule() {
        IRule iRule;
        switch(rule){
            case "RandomRule":
                iRule = new RandomRule();
                break;
            case "RoundRobinRule":
                iRule = new RoundRobinRule();
                break;
            case "RetryRule":
                iRule = new RetryRule();
                break;
            case "BestAvailableRule":
                iRule = new BestAvailableRule();
                break;
            case "AvailabilityFilteringRule":
                iRule = new AvailabilityFilteringRule();
                break;
//            case "ResponseTimeWeightedRule":
//                iRule = new ResponseTimeWeightedRule();
//                break;
            case "ZoneAvoidanceRule":
                iRule = new ZoneAvoidanceRule();
                break;
            default:
                iRule = new RandomRule();
                break;
        }
        return iRule;
    }

}
