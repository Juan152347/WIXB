package com.wixteam.barbershop.Services.Date.Application.All;

import com.wixteam.barbershop.Services.Date.Domain.Date;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class allDate {
    private List<Date> dates;

    public allDate(List<Date> date) {
        this.dates = date;
    }

    public List<HashMap<String,Object>> response (){
        return dates.stream().map( date -> date.data()).collect(Collectors.toList());
    }
}
