package com.firebase.jobdispatcher.testapp;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.widget.EditText;

import com.firebase.jobdispatcher.RetryStrategy;

/** POJO that represents the job form (via databinding). */
public class JobForm extends BaseObservable {
    public final ObservableField<String> tag = new ObservableField<>("");

    private int winStartSeconds = 30;
    private int winEndSeconds = 60;
    private int initialBackoffSeconds = 30;
    private int maximumBackoffSeconds = 3600;

    public final ObservableBoolean constrainOnAnyNetwork = new ObservableBoolean(true);
    public final ObservableBoolean constrainOnUnmeteredNetwork = new ObservableBoolean(false);
    public final ObservableBoolean constrainDeviceCharging = new ObservableBoolean(false);

    public final ObservableBoolean recurring = new ObservableBoolean(false);
    public final ObservableBoolean persistent = new ObservableBoolean(false);
    public final ObservableBoolean replaceCurrent = new ObservableBoolean(false);

    public final ObservableInt retryStrategy = new ObservableInt(RetryStrategy.RETRY_POLICY_EXPONENTIAL);

    @Bindable
    public String getWinEndSecondsStr() {
        return String.valueOf(winEndSeconds);
    }

    @Bindable
    public String getWinStartSecondsStr() {
        return String.valueOf(winStartSeconds);
    }

    public void setWinStartSecondsStr(String in) {
        winStartSeconds = Integer.valueOf(in, 10);
    }

    public void setWinEndSecondsStr(String in) {
        winEndSeconds = Integer.valueOf(in, 10);
    }

    @Bindable
    public String getInitialBackoffSecondsStr() {
        return String.valueOf(initialBackoffSeconds);
    }

    public void setInitialBackoffSecondsStr(String in) {
        this.initialBackoffSeconds = Integer.valueOf(in, 10);
    }

    @Bindable
    public String getMaximumBackoffSecondsStr() {
        return String.valueOf(maximumBackoffSeconds);
    }

    public void setMaximumBackoffSecondsStr(String in) {
        this.maximumBackoffSeconds = Integer.valueOf(in, 10);
    }

    public int getWinStartSeconds() {
        return winStartSeconds;
    }

    public int getWinEndSeconds() {
        return winEndSeconds;
    }

    public int getInitialBackoffSeconds() {
        return initialBackoffSeconds;
    }

    public int getMaximumBackoffSeconds() {
        return maximumBackoffSeconds;
    }

}
