package generateordernumber.generator;

import generateordernumber.constant.OrderConstant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
public class Generator {

    /**
     * 生成订单号
     * @return
     */
    public static String generatorOrderNumber() {
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String orderConstant01 = OrderConstant.ORDERCONSTANT01;
        String twoRandom01 = generatorTowRandom();
        String orderConstant02 = OrderConstant.ORDERCONSTANT02;
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());
        String twoRandom02 = generatorTowRandom();
        return date + orderConstant01 + twoRandom01 + orderConstant02 + seconds + twoRandom02;
    }

    /**
     * 生成两位随机数
     * @return
     */
    public static String generatorTowRandom() {
        Random random = new Random();
        String result = String.valueOf(random.nextInt(100));
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }
}
