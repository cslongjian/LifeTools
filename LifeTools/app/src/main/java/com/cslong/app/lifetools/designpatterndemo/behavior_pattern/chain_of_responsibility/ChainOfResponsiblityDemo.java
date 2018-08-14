package com.cslong.app.lifetools.designpatterndemo.behavior_pattern.chain_of_responsibility;

public class ChainOfResponsiblityDemo {


    /**
     *
     * @param args
     *
     *    职责链模式（Chain of Responsibility）：使多个对象都有机会处理同一个请求，从而避免请求的发送者和接收者之间的耦合关系。
     *    将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
     *
     *     为完成同一个请求，如果存在多个请求处理器以及未知请求处理器个数或者请求处理器可动态配置的情况下，可以考虑使用责任链模式。
     *     如OKHttp的拦截器就是使用的责任链模式。
     *
     *
     *
     *     demo
     *       在公司内部员工请假一般情况是这样的：员工在OA系统中提交一封请假邮件，该邮件会自动转发到你的直接上级领导邮箱里，
     *       如果你的请假的情况特殊的话，该邮件也会转发到你上级的上级的邮箱，根据请假的情况天数多少，系统会自动转发相应的责任人的邮箱。
     *       我们就以这样一种场景为例完成一个责任链模式的代码。为了更清晰的描述这种场景我们规定如下：
            ① GroupLeader（组长 ）：他能批准的假期为2天，如果请假天数超过2天就将请假邮件自动转发到组长和经理邮箱。
            ② Manager（经理）：他能批准的假期为4天以内，如果请假天数大于4天将该邮件转发到自动转发到组长、经理和部门领导的邮箱。
            ③ DepartmentHeader（部门领导）：他能批准的假期为7天以内，如果大于7天就只批准7天。
     */
    public static void main(String[] args) {

        Request request = new Request.Builder().setName("张三").setDays(5)
                .setReason("事假").build();
        ChainOfResponsibilityClient client = new ChainOfResponsibilityClient();
        client.addRatifys(new CustomInterceptor());
        Result result = client.execute(request);

        System.out.println("结果：" + result.toString());

    }
}
