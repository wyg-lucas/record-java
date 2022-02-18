package com.lucas.leetcode.solution;

import java.util.zip.CheckedOutputStream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2022/2/18
 */


public class Solution51 {
    //利用归并排序解答，在合并的时候，当左边的大于右边的，就计算逆序数。
    //逆序数计算公式：mid - left + 1
    //定义一个全局的计数器变量
    int count = 0;
    public int reverseParis(int[] nums) {
        this.count = 0;
        mergesort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergesort(int[] nums, int left, int right) {
        //当归并完只有一个节点的时候，直接返回，退出递归
        if (left >= right) {
            return ;
        }
        int mid = (left + right) / 2;
        //左拆分
        mergesort(nums, left, mid);
        //右拆分
        mergesort(nums, mid+1, right);
        //合并
        merge(nums,left,mid,right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        //定义一个指针，指向第一个数组的第一个元素
        int i = left;
        //定义一个指针，指向第二个数组的第一个元素
        int j = mid+1;
        //定义一个指针，指向临时数组的第一个元素
        int t = 0;
        //定义一个临时数组，当归并完之后数组是有序的
        int[] tmp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            //比较两个数组的元素，取较小的元素加入到临时数组中
            //并将两个指针指向下一个元素
            if (nums[i] <= nums[j]) {
                tmp[t++] = nums[i++];
            } else {
                //当左边数组的数大于右边数组的元素时，就对当前元素以及后面的元素的个数进行统计，
                //此时这个数就是一个逆序对
                //定义一个计数器，记下每次合并中存在的逆序对数
                count += mid - i + 1;
                tmp[t++] = nums[j++];
            }
        }
        //当左边的数组没有遍历完成后，直接将剩余元素加入到临时数组中
        while (i <= mid) {
            tmp[t++] = nums[i++];
        }
        //当右边的数组没有遍历完成后，直接将剩余的元素加入到临时数组中
        while (j <= right) {
            tmp[t++] = nums[j++];
        }
        //将新数组中的元素，覆盖nums旧数组中的元素
        //此时数组中的元素已经是有序的了
        for (int k = 0; k < tmp.length; ++k) {
            nums[left+k] = tmp[k];
        }
    }


    public static void main(String[] args) {
        Solution51 solution = new Solution51();
        int[] nums = new int[] {7,5,6,4};
        int ans = solution.reverseParis(nums);
        System.out.println(ans);

    }
}
