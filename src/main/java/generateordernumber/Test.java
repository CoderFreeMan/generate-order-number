package generateordernumber;

import generateordernumber.generator.Generator;

import java.util.Calendar;

/**
 * <p> Date             :2018/5/30 </p>
 * <p> Module           : </p>
 * <p> Description      : </p>
 * <p> Remark           : </p>
 *
 * @author yangdejun
 * @version 1.0
 * <p>--------------------------------------------------------------</p>
 * <p>修改历史</p>
 * <p>    序号    日期    修改人    修改原因    </p>
 * <p>    1                                     </p>
 */
public class Test {
    public static void main(String[] args) {
        String orderNumber;
//        System.out.println(Calendar.getInstance().getTimeInMillis());
        for (int i = 0; i < 100000; i ++) {
            orderNumber = Generator.generatorOrderNumber();
            System.out.println(orderNumber);
        }
        System.out.println(Calendar.getInstance().getTimeInMillis());
    }
}
