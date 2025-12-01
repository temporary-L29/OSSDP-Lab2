package org.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;

/**
 * 测试类：L20240001_7_Test
 *
 * 测试用例设计总体原则：
 * 1. 等价类划分：根据输入条件划分等价类，包括正常情况、边界情况、异常情况
 * 2. 边界值分析：针对字符串长度、pairs数量等边界值设计测试用例
 * 3. 功能覆盖：确保覆盖所有主要功能路径
 * 4. 错误推测：基于常见错误类型设计测试用例
 *
 * 测试覆盖的等价类：
 * - 空pairs列表
 * - 单个pair
 * - 多个pairs形成连通分量
 * - 多个pairs形成多个连通分量
 * - 边界情况：最小长度、最大长度
 * - 重复pairs
 * - 自环pairs
 */

public class L2023112920_7_Test {

    private Solution7 solution;

    @Before
    public void setUp() {
        solution = new Solution7();
    }

    /**
     * 测试目的：验证基本功能，多个pairs形成连通分量
     * 测试用例：示例1 - 正常交换情况
     * 输入：s = "dcab", pairs = [[0,3],[1,2]]
     * 预期输出："bacd"
     */
    @Test
    public void testExample1() {
        String s = "dcab";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0, 3),
                Arrays.asList(1, 2)
        );
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertEquals("bacd", result);
    }

    /**
     * 测试目的：验证多个pairs形成复杂连通分量的情况
     * 测试用例：示例2 - 复杂交换情况
     * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
     * 预期输出："abcd"
     */
    @Test
    public void testExample2() {
        String s = "dcab";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0, 3),
                Arrays.asList(1, 2),
                Arrays.asList(0, 2)
        );
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertEquals("abcd", result);
    }

    /**
     * 测试目的：验证连续交换的情况
     * 测试用例：示例3 - 链式交换
     * 输入：s = "cba", pairs = [[0,1],[1,2]]
     * 预期输出："abc"
     */
    @Test
    public void testExample3() {
        String s = "cba";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2)
        );
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertEquals("abc", result);
    }

    /**
     * 测试目的：验证空pairs列表的情况
     * 测试用例：边界情况 - 无交换对
     * 输入：s = "abc", pairs = []
     * 预期输出："abc"（保持不变）
     */
    @Test
    public void testEmptyPairs() {
        String s = "abc";
        List<List<Integer>> pairs = new ArrayList<>();
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertEquals("abc", result);
    }

    /**
     * 测试目的：验证单个pair的情况
     * 测试用例：边界情况 - 单个交换对
     * 输入：s = "ba", pairs = [[0,1]]
     * 预期输出："ab"
     */
    @Test
    public void testSinglePair() {
        String s = "ba";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0, 1)
        );
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertEquals("ab", result);
    }

    /**
     * 测试目的：验证多个连通分量的情况
     * 测试用例：功能覆盖 - 多个独立连通分量
     * 输入：s = "dcba", pairs = [[0,1],[2,3]]
     * 预期输出："cdab" 或 "badc"（注意：实际结果取决于具体实现）
     * 解释：[0,1]可以交换得到"cdba"，[2,3]可以交换得到"dcab"，但两个连通分量独立
     */
    @Test
    public void testMultipleComponents() {
        String s = "dcba";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(2, 3)
        );
        String result = solution.smallestStringWithSwaps(s, pairs);
        // 第一个连通分量[0,1]：'d','c'排序后为'c','d'
        // 第二个连通分量[2,3]：'b','a'排序后为'a','b'
        // 所以结果是"cdab"
        assertEquals("cdab", result);
    }

    /**
     * 测试目的：验证重复pairs的情况
     * 测试用例：边界情况 - 重复交换对
     * 输入：s = "cba", pairs = [[0,1],[0,1],[1,2]]
     * 预期输出："abc"
     */
    @Test
    public void testDuplicatePairs() {
        String s = "cba";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 1),
                Arrays.asList(1, 2)
        );
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertEquals("abc", result);
    }

    /**
     * 测试目的：验证自环pair的情况
     * 测试用例：边界情况 - 自环交换对
     * 输入：s = "abc", pairs = [[0,0],[1,1]]
     * 预期输出："abc"（保持不变）
     */
    @Test
    public void testSelfLoopPairs() {
        String s = "abc";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(1, 1)
        );
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertEquals("abc", result);
    }

    /**
     * 测试目的：验证最小长度字符串的情况
     * 测试用例：边界情况 - 长度为1的字符串
     * 输入：s = "a", pairs = []
     * 预期输出："a"
     */
    @Test
    public void testMinLengthString() {
        String s = "a";
        List<List<Integer>> pairs = new ArrayList<>();
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertEquals("a", result);
    }

    /**
     * 测试目的：验证所有字符相同的情况
     * 测试用例：边界情况 - 无变化可能
     * 输入：s = "aaaa", pairs = [[0,1],[2,3]]
     * 预期输出："aaaa"
     */
    @Test
    public void testAllSameCharacters() {
        String s = "aaaa";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(2, 3)
        );
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertEquals("aaaa", result);
    }

    /**
     * 测试目的：验证复杂连通分量的情况
     * 测试用例：功能覆盖 - 星形连接
     * 输入：s = "edcba", pairs = [[0,1],[0,2],[0,3],[0,4]]
     * 预期输出："abcde"
     */
    @Test
    public void testStarConnection() {
        String s = "edcba";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 2),
                Arrays.asList(0, 3),
                Arrays.asList(0, 4)
        );
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertEquals("abcde", result);
    }

    /**
     * 测试目的：验证性能边界情况
     * 测试用例：性能测试 - 中等规模输入
     * 输入：长度为100的字符串，50个随机pairs
     */
    @Test
    public void testMediumScale() {
        // 生成测试数据
        int len = 100;
        StringBuilder sb = new StringBuilder();
        Random random = new Random(42); // 固定种子保证可重复性

        for (int i = 0; i < len; i++) {
            sb.append((char)('a' + random.nextInt(26)));
        }
        String s = sb.toString();

        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int a = random.nextInt(len);
            int b = random.nextInt(len);
            pairs.add(Arrays.asList(a, b));
        }

        // 主要测试是否能在合理时间内完成，不出现异常
        String result = solution.smallestStringWithSwaps(s, pairs);
        assertNotNull(result);
        assertEquals(len, result.length());
    }
}
