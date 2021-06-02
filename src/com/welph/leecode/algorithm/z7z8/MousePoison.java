package com.welph.leecode.algorithm.z7z8;

/**
 * 有1000瓶药水，其中一瓶是有毒的，老鼠喝掉药水后，毒性会在24小时后发作。
 * 那最少需要多少只老鼠，能够在24小时后找出哪一瓶有毒呢？
 */
public class MousePoison {

    public static void main(String[] args) {

    }

    /**
     * -- 2瓶, 则需要1个老鼠
     * -- 4瓶, 则需要2个老鼠 0 1 2 3
     *   一个老鼠喝 0,1
     *   一个老鼠喝 1,3
     * -- 8瓶, 则需要3个老鼠 0 1 2 3 4 5 6 7
     *   一个老鼠喝 4,5,6,7
     *   一个老鼠喝 2,3,6,7
     *   一个老鼠喝 1,3,5,7
     * --..... 二分思想 对应于二进制
     *           0   1     2    3    4    5    6    7
     *
     * 一号老鼠   0   0     0    0    1    1    1    1
     * 二号老鼠   0   0     1    1    1    1    0    0
     * 三号老鼠   0   1     0    1    0    1    0    1
     *--------   000  001  010  011  110  111  100  101
     * 对于8瓶来说 满足了所有的情况
     * -- 最终答案就是: [大于target的最小最高位值]
     */
}
