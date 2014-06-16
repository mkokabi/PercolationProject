/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package percolationproject;

/**
 *
 * @author Mohsen
 */
public class PercolationStats {

    /**
     * perform T independent computational experiments on an N-by-N grid
     *
     * @param N
     * @param T
     */
    public PercolationStats(int N, int T) {
        for (int i = 0; i < T; i++) {
            Percolation percolation = new Percolation(N);
            percolation.open(1, 1);
        }
        
    }

    /**
     * sample mean of percolation threshold
     *
     * @return
     */
    public double mean() {
        return 0;
    }

    /**
     * sample standard deviation of percolation threshold
     *
     * @return
     */
    public double stddev() {
        return 0;
    }

    /**
     * returns lower bound of the 95% confidence interval
     *
     * @return
     */
    public double confidenceLo() {
        return 0;
    }

    /**
     * returns upper bound of the 95% confidence interval
     *
     * @return
     */
    public double confidenceHi() {
        return 0;
    }

    /**
     * test client, described below
     *
     * @param args
     */
    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(10, 1);
        
    }
}
