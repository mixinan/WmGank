package cc.guoxingnan.wmgank.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RandomResultModel implements Serializable {
    @SerializedName("error")
    private boolean error;

    @SerializedName("results")
    private List<List<GankModel>> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<List<GankModel>> getResults() {
        return results;
    }

    public void setResults(List<List<GankModel>> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "RandomResultModel{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
