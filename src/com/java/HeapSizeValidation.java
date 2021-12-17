package com.java;

public class HeapSizeValidation {

    public static void main(String args[]){
        long heapSize = Runtime.getRuntime().totalMemory();
        long heapMaxsize = Runtime.getRuntime().maxMemory();
        long heapFreeSize = Runtime.getRuntime().freeMemory();
        System.out.println(formatSize(heapSize));
        System.out.println(formatSize(heapMaxsize));
        System.out.println(formatSize(heapFreeSize));
    }

    public static String formatSize(long v) {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB", (double)v / (1L << (z*10)), " KMGTPE".charAt(z));
    }
}
