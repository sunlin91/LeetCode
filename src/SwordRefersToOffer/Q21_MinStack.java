package SwordRefersToOffer;

import java.util.Stack;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Q21_MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> smin = new Stack<>();
    public void push(int node) {
        if (!smin.isEmpty()&&smin.peek()<node){
            s.push(node);
        }else if (smin.isEmpty()||smin.peek()>=node){
            s.push(node);
            smin.push(node);
        }
    }

    public void pop() {
        if (s.peek()>smin.peek()){
            s.pop();
        }else {
            s.pop();
            smin.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return smin.peek();
    }
}
