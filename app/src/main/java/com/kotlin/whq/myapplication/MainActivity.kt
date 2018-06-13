package com.kotlin.whq.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //     array()
        //     zifuchuan()
        //     Conllection()
        //  List()
        map()

    }

    fun array() {
        //数组定义,两种方式
        var int_array: IntArray = intArrayOf(1, 2, 3)
        var double_array: DoubleArray = doubleArrayOf(1.0, 2.1, 3.1)

        var int_arrays: Array<Int> = arrayOf(1, 3, 1);
        var double_arrays: Array<Double> = arrayOf(2.3, 4.5, 4.5)
        var string_arrays: Array<String> = arrayOf("how", "are", "you")

        var one: String = ""
        var second: String = ""
        var i: Int = 0;
        while (i < int_array.size) {
            one = one + int_array[i] + ","
            second = second + string_arrays[i] + ","
            i++
        }
        tv_main1.text = one;
        tv_main2.text = second;
    }

    fun zifuchuan() {
        //kotline兼容java,查找子串都用indexOf，截取都用substring，替换都用replace，指定字符分割都用split
        var dou: Double = 13.45
        val origin: String = dou.toString();//toInt, toDouble,toBoolean,toLong
        var strList: List<String> = origin.split(".")
        var strResult: String = ""

        //for-in 循环
        for (item in strList) {
            strResult = strResult + item + ","
        }
        tv_main3.text = strResult

        //字符串拼接用${内容}
        tv_main4.text = "字符串拼接${'$'}元钱字符==${strList.size}拼接个数== $strResult 正常情况"

    }

    fun Conllection() {

        /**
         * 集合遍历三种方式
         * 集合set --只读，无序，元素唯一     MutableSet--加了前缀后可以增删改查
         */
        val goodlMutSet: Set<String> = setOf("小米8", "iphoneXX", "oppor11", "华为Not", "魅族", "vivoooo33")
        var des = ""
        //方式一：for--in循环
        for (name in goodlMutSet) {
            des = "${des}名称:${name}\n"
        }
        Log.d("whq", "for_in遍历手机数组包含以下${goodlMutSet.size}款手机:\n$des")

        /**
         * 方式二：迭代器
         * 迭代器本身指向元素的存放地址，其实是遍历所有元素的地址。
         * 通过hasNext判断是否有下一个节点，如果没有则遍历结束，通过next方法获得下一个节点的元素
         */
        var desc = ""
        val iterator = goodlMutSet.iterator()
        while (iterator.hasNext()) {
            val itemsname = iterator.next();
            desc = "${desc}手机品牌：${itemsname}\n"
        }
        Log.d("whq", "while迭代器手机畅销排行榜包含以下${goodlMutSet.size}款手机：\n$desc")
        /**
         * 方式三 :forEach
         */
        var desfor = ""
        goodlMutSet.forEach {
            desfor = "${desfor}手机名称：${it}\n"//it代表集合中的元素
        }
        Log.d("whq", "forEach便利查询了以下${goodlMutSet.size}种手机：\n$desfor")
    }

    fun List() {
        /**
         *  队列List --只读，有序，不唯一     MutableList--加了前缀后可以增删改查
         *  方式一：for--in遍历
         */
        val goodlMutList: List<String> = listOf("xiaomi8", "iphoneXX", "oppor11", "华为Not", "魅族", "vivoooo33")
        val goodlMutListss: List<Int> = mutableListOf(7, 4, 8, 2, 3, 1, 0)
        /*  var des = ""
          for( hh in goodlMutList.indices){//indices是队列的下标数组，取值为 0~goodMuList.size-1,hh代表数据数组内的元素
              val item = goodlMutList[hh]
              des = "${des}手机名称：${item}\n"
          }
          Log.d("whq", "队列List遍历查询\n$des")*/
        /**
         * 排序，
         * MutableList提供了sort系列方法用于给队列中的元素重新排序
         * sortBy--按照指定条件升序排列
         * sortByDescending--按照指定条件降序排列
         */
        var sorat = false;
        tv_main4.setOnClickListener {
            if (sorat) {
                //sortBy升序排列
                goodlMutList.sortedBy { it.length }//it.lenght默认条件
                goodlMutListss.sortedBy { it % 3 }//it.lenght默认条件
                //sortByDescending降序排列
            } else {
                goodlMutList.sortedByDescending { it.length }
                goodlMutListss.sortedByDescending { it % 3 }
            }
            var desc = ""
            for (items in goodlMutListss) {
                desc = "${desc} 名称哈哈哈：${items}\n"
            }
            Log.d("whq", "手机排序按照${if (sorat) "升序" else "降序"}重新排列：\n$desc")
            sorat = !sorat
        }
    }

    fun map() {
        /**
         * 映射Map/MutableMap--加了前缀后可以增删改查
         * 两种方式表达单个键值对元素  “键名“ to ”键值”--- “Pair(键名，键值)”
         * map可以用for--in，迭代器，forEach完成遍历
         */
        val goodsMap: Map<String, String> = mapOf("苹果" to "iphoneX", "小米" to "xiamiX6", "oppo" to "R15",
                "华为" to "huawei8")
        val goodsMuMap: MutableMap<String, String> = mutableMapOf(Pair("香蕉", "balance"), Pair("大米", "mifan"),
                Pair("vivo", "Vivos"))
        var staty = 0

            //使用for--in循环
            tv_main1.setOnClickListener {
                if(staty ==0){
                    var dec = ""
                    for (item in goodsMap) {
                        dec = "${dec}厂家：${item.key}==产品名称${item.value}\n"
                    }
                    Log.d("whq", "for-in遍历出了${goodsMap.size}款手机：\n$dec")
                    staty = 1
                }else if (staty == 1) {
                    //利用迭代器循环
                    //创建构造器对象
                    var itera = goodsMuMap.iterator()
                    var desc = ""
                    //从构造器中遍历每一个元素
                    while (itera.hasNext()) {
                        //取出构造器中的每一个元素
                        val items = itera.next()
                        desc = "${desc}迭代器厂家：${items.key}--产品名称${items.value}\n"
                    }
                    Log.d("whq", "迭代器遍历出了${goodsMuMap.size}款产品：\n$desc")
                    staty = 2
                }else{
                    var descs = ""
                    goodsMuMap.forEach { key, value ->
                        descs = "${descs}厂家:${key}==产品名称${value}\n"
                    }
                    Log.d("whq", "用forEach遍历出了数组共有${goodsMuMap.size}款手机，详情为：\n$descs")
                    staty = 0
                }

        }

    }

}
