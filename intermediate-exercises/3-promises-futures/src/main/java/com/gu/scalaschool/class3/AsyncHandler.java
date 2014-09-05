package com.gu.scalaschool.class3;

/** Modelled on AWS's own AsyncHandler */
public interface AsyncHandler<A> {
    /**
     * Invoked after an asynchronous request fails.
     *
     * @param exception The error.
     */
    public void onError(Exception exception);

    /**
     * Invoked after an asynchronous request completes successfully.
     *
     * @param a The value of the request.
     */
    public void onSuccess(A a);
}
