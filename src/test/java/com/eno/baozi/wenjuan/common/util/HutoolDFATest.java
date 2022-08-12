package com.eno.baozi.wenjuan.common.util;

import cn.hutool.dfa.WordTree;

public class HutoolDFATest {

    public static void main(String[] args) {
        String text = "标准匹配，匹配到最短关键词，并跳过已经匹配的关键词";
        WordTree wordTree  = new WordTree();
        wordTree.addWord("关键词");
        wordTree.addWord("跳过");
        System.out.println(wordTree.match(text));


    }
}
