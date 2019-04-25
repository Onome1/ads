package com.cs401.ads;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MechanicInfo {
    @GET("mechanic")
    Call<MechanicContainer> list();
}
