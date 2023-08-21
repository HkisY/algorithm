package com.Hxin.leetcode.middle.day25;

/**
 * 给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
 * 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
 * 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
 * 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * <p>
 * start = "_L__R__R_", target = "L______RR"
 * <p>
 * 输出：
 * <p>
 * true
 * <p>
 * 解释：
 * <p>
 * 可以从字符串 start 获得 target ，需要进行下面的移动：
 * <p>
 * - 将第一个片段向左移动一步，字符串现在变为 "L___R__R_" 。
 * <p>
 * - 将最后一个片段向右移动一步，字符串现在变为 "L___R___R" 。
 * <p>
 * - 将第二个片段向右移动三步，字符串现在变为 "L______RR" 。
 * <p>
 * 可以从字符串 start 得到 target ，所以返回 true 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：start = "R_L_", target = "__LR"
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 字符串 start 中的 'R' 片段可以向右移动一步得到 "_RL_" 。
 * 但是，在这一步之后，不存在可以移动的片段，所以无法从字符串 start 得到 target 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：
 * <p>
 * start = "_R", target = "R_"
 * <p>
 * 输出：
 * <p>
 * false
 * <p>
 * 解释：
 * <p>
 * 字符串 start 中的片段只能向右移动，所以无法从字符串 start 得到 target 。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/21 20:15
 */
public class CanChange {
    public static void main(String[] args) {
//        String start = "_L__R__R_", target = "L______RR";
//        String start = "R_L_", target = "__LR";
//        String start = "_R", target = "R_";
//        String start = "_LL__R__R_", target = "L___L___RR";//false
//        String start = "_L__R__R_", target = "L______RR";
        String start = "_LL__R__R_", target = "L___L___RR";
        System.out.println(canChange(start, target));

    }

    public static boolean canChange(String start, String target) {
        //初始判断
        int startLNum = 0, targetRNum = 0, startRNum = 0, targetLNum = 0;
        char[] startChars = start.toCharArray();
        char[] targetChars = target.toCharArray();
        StringBuilder sbStart = new StringBuilder();
        StringBuilder sbTarget = new StringBuilder();
        for (char startChar : startChars) {
            if (startChar == 'L') {
                sbStart.append(startChar);
                startLNum++;
            } else if (startChar == 'R') {
                sbStart.append(startChar);
                startRNum++;
            }

        }
        for (char targetChar : targetChars) {
            if (targetChar == 'L') {
                sbTarget.append(targetChar);
                targetLNum++;
            } else if (targetChar == 'R') {
                sbTarget.append(targetChar);
                targetRNum++;
            }
        }
        //字符数目相等
        if (startLNum != targetLNum || startRNum != targetRNum) {
            return false;
        }
        //去除'_'后排序相等
        if (!sbStart.toString().equals(sbTarget.toString())) {
            return false;
        }
        int startLeftPoint = 0, targetLeftPoint = 0;
        //标记
        boolean legal = false;

        for (; targetLeftPoint < startChars.length; targetLeftPoint++) {
            char tar = targetChars[targetLeftPoint];
            if (tar != '_') {
                if (startChars[startLeftPoint] == tar && startLeftPoint == targetLeftPoint) {
                    startLeftPoint++;
                    continue;
                }
                if (tar == 'L') {
                    for (; startLeftPoint < startChars.length; startLeftPoint++) {
                        char sta = startChars[startLeftPoint];
                        if (sta == '_') {
                            legal = true;
                        } else if (sta == 'R') {
                            return false;
                        } else if (sta == 'L') {
                            if (startLeftPoint < targetLeftPoint) {
                                return false;
                            }
                            if (legal) {
                                legal = false;
                                startChars[startLeftPoint] = '_';
                                break;
                            } else {
                                return false;
                            }
                        }
                    }
                } else if (tar == 'R') {
                    for (; startLeftPoint < startChars.length; startLeftPoint++) {
                        if (startLeftPoint > targetLeftPoint) {
                            return false;
                        }
                        char sta = startChars[startLeftPoint];
                        if (sta == '_') {
                            if (legal) {
                                legal = false;
                                startChars[startLeftPoint] = '_';

                                break;
                            }
                        } else if (sta == 'L') {
                            return false;
                        } else if (sta == 'R') {
                            legal = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean canChangeWay(String start, String target){
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != target.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != '_') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (target.charAt(j) != '_') {
                return false;
            }
            j++;
        }
        return true;
    }
}
