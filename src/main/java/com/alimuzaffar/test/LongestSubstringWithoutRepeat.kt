package com.alimuzaffar.test

fun main() {
    val start = System.currentTimeMillis()
    println(lengthOfLongestSubstring("abcabcbb"))  //3
    println(lengthOfLongestSubstring("bbbbb")) //1
    println(lengthOfLongestSubstring("pwwkew")) //3
    println(lengthOfLongestSubstring("abcdefgbijklmnopqr")) //16
    println(lengthOfLongestSubstring(" ")) //1
    println(lengthOfLongestSubstring("asjrgapa")) //6
    println(lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!")) //63
    println(lengthOfLongestSubstring("aabaab!bb!")) //3
    println(lengthOfLongestSubstring("abba")) //2
    println(lengthOfLongestSubstring("aa")) //1
    println(lengthOfLongestSubstring("aab")) //2
    println(lengthOfLongestSubstring("uqinntq")) //4
    println("Run time = ${System.currentTimeMillis() - start}ms")
}

fun lengthOfLongestSubstring(s: String): Int {
    val sl = s.length
    if (sl == 1 || (sl == 2 && s[0] == s[1])) {
        return 1
    } else if (sl == 2) {
        return 2
    }
    val b = StringBuilder("")
    var l = 0
    for (c in s) {
        val i = b.indexOf(c)
        if (i > -1) {
            if (b.length > l) {
                l = b.length
            }
            b.delete(0, i + 1)
            b.append(c)
        } else {
            b.append(c)
        }
    }
    return if (b.length > l) {
        b.length
    } else {
        l
    }

}

