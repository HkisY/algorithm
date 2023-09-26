package com.Hxin.markableQus.calculate;

import java.util.List;

/**
 * 770
 * <p>
 * 给定一个表达式如 expression = "e + 8 - a + 5" 和一个求值映射，如 {"e": 1}（给定的形式为 evalvars = ["e"] 和 evalints = [1]），返回表示简化表达式的标记列表，例如 ["-1*a","14"]
 * <p>
 * 表达式交替使用块和符号，每个块和符号之间有一个空格。
 * <p>
 * 块要么是括号中的表达式，要么是变量，要么是非负整数。
 * <p>
 * 变量是一个由小写字母组成的字符串（不包括数字）。请注意，变量可以是多个字母，并注意变量从不具有像 "2x" 或 "-x" 这样的前导系数或一元运算符 。
 * <p>
 * 表达式按通常顺序进行求值：先是括号，然后求乘法，再计算加法和减法。
 * <p>
 * 例如，
 * <p>
 * expression = "1 + 2 * 3" 的答案是 ["7"]。
 * <p>
 * 输出格式如下：
 * <p>
 * 对于系数非零的每个自变量项，我们按字典排序的顺序将自变量写在一个项中。
 * <p>
 * 例如，我们永远不会写像 “b*a*c” 这样的项，只写 “a*b*c”。
 * <p>
 * 项的次数等于被乘的自变量的数目，并计算重复项。我们先写出答案的最大次数项，用字典顺序打破关系，此时忽略词的前导系数。
 * <p>
 * 例如，
 * <p>
 * "a*a*b*c" 的次数为 4。
 * <p>
 * 项的前导系数直接放在左边，用星号将它与变量分隔开(如果存在的话)。前导系数 1 仍然要打印出来。
 * <p>
 * 格式良好的一个示例答案是 ["-2*a*a*a", "3*a*a*b", "3*b*b", "4*a", "5*c", "-6"] 。
 * <p>
 * 系数为 0 的项（包括常数项）不包括在内。
 * <p>
 * 例如，
 * <p>
 * “0” 的表达式输出为 [] 。
 * <p>
 * 注意：你可以假设给定的表达式均有效。所有中间结果都在区间 [-231, 231 - 1] 内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "e + 8 - a + 5", evalvars = ["e"], evalints = [1]
 * <p>
 * 输出：["-1*a","14"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：expression = "e - 8 + temperature - pressure",
 * <p>
 * evalvars = ["e", "temperature"], evalints = [1, 12]
 * <p>
 * 输出：["-1*pressure","5"]
 * <p>
 * 示例 3：
 * <p>
 * 输入：expression = "(e + 8) * (e - 8)", evalvars = [], evalints = []
 * <p>
 * 输出：["1*e*e","-64"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 250
 * <p>
 * expression 由小写英文字母，数字 '+', '-', '*', '(', ')', ' ' 组成
 * <p>
 * expression 不包含任何前空格或后空格
 * <p>
 * expression 中的所有符号都用一个空格隔开
 * <p>
 * 0 <= evalvars.length <= 100
 * <p>
 * 1 <= evalvars[i].length <= 20
 * <p>
 * evalvars[i] 由小写英文字母组成
 * <p>
 * evalints.length == evalvars.length
 * <p>
 * -100 <= evalints[i] <= 100
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/26  17:59
 */
public class CalculateFour {
    public static void main(String[] args) {

    }

    public List<String> basicCalculatorIV(String expression, String[] evalVars, int[] evalInts) {
        return null;
    }
}
