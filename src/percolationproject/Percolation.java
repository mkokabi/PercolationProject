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
public class Percolation {

    private final int n;
    private final boolean[] filled;
    private final boolean[] opened;
    private final WeightedQuickUnionUF grid;

    /**
     * create N-by-N grid, with all sites blocked
     *
     * @param N
     */
    public Percolation(int N) {
        this.n = N;
        // add a virtual point on Top (0) and a 
        // virtaul point at the bottom (N*N + 1)
        this.grid = new WeightedQuickUnionUF((N * N) + 2);
        this.filled = new boolean[(N * N) + 2];
        for (int i = 0; i < N * N; i++) {
            this.filled[i] = true;
        }
        this.opened = new boolean[(N * N) + 2];
        for (int i = 0; i < N * N; i++) {
            this.opened[i] = false;
        }

        // connect top row sites to the top VP
        for (int j = 1; j <= N; j++) {
            this.grid.union(0, j);
        }

        // connect top row sites to the top VP
        for (int j = 1; j <= N; j++) {
            this.grid.union((N * N) + 1, ((N - 1) * N) + j);
        }
    }

    /**
     * open site (row i, column j) if it is not already
     *
     * @param i: starts from 1 to N
     * @param j: starts from 1 to N
     */
    public void open(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        if (isOpen(i, j)) {
            return;
        }

        int index = ((i - 1) * n) + j;
        int indexOfAdj;

        // check top one 
        if (i > 1 && !isFull(i - 1, j)) {
            indexOfAdj = ((i - 1) * n) + j;
            this.grid.union(index, indexOfAdj);
        }

        // check bottom one
        if (i < n - 1 && !isFull(i + 1, j)) {
            indexOfAdj = ((i + 1) * n) + j;
            this.grid.union(index, indexOfAdj);
        }

        //check left one
        if (j > 1 && !isFull(i, j - 1)) {
            indexOfAdj = (i * n) + (j - 1);
            this.grid.union(index, indexOfAdj);
        }

        //check right one
        if (j < n - 1 && !isFull(i, j + 1)) {
            indexOfAdj = (i * n) + (j + 1);
            this.grid.union(index, indexOfAdj);
        }

        this.opened[(i - 1) * n + (j - 1)] = true;
    }

    /**
     * is site (row i, column j) open?
     *
     * @param i
     * @param j
     * @return
     */
    public boolean isOpen(int i, int j) {
        return this.opened[((i - 1) * n) + j];
    }

    /**
     * is site (row i, column j) full?
     *
     * @param i
     * @param j
     * @return
     */
    public boolean isFull(int i, int j) {
        return filled[((i - 1) * n) + j];
    }

    /**
     * does the system percolate?
     *
     * @return
     */
    public boolean percolates() {
        return this.grid.connected(0, (n * n) + 1);
    }

}
