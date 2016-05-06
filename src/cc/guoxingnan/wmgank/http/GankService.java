package cc.guoxingnan.wmgank.http;

import cc.guoxingnan.wmgank.entity.NewResultModel;
import cc.guoxingnan.wmgank.entity.ResultModel;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GankService {


    @GET("/day/{year}/{month}/{day}")
    void getNewData(@Path("year") String year, @Path("month") String month, @Path("day") String day, Callback<NewResultModel> callback);

    @GET("/data/{type}/{count}/{page}")
    void getTypeData(@Path("type") String type, @Path("count") String count, @Path("page") String page, Callback<ResultModel> callback);

    @GET("/random/data/{type}/{count}")
    void getRandomData(@Path("type") String type, @Path("count") String count, Callback<ResultModel> callback);

}
