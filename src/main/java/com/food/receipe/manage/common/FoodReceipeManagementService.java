package com.food.receipe.manage.common;

import com.food.receipe.manage.adapter.in.http.InputRequest;
import com.food.receipe.manage.adapter.out.db.FoodReceipe;
import com.food.receipe.manage.adapter.out.db.FoodReceipeRepository;
import com.food.receipe.manage.adapter.out.http.OutputResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Slf4j
@AllArgsConstructor
@Service
public class FoodReceipeManagementService {

    private  FoodReceipeRepository repository;

    @Transactional
    public void addReceipe(InputRequest request) throws ServiceException{
        FoodReceipe receipe = null;
        try{
             receipe = repository.save(translate(request));
        }catch(Exception e){
            throw new ServiceException(receipe.getId(),e);
        }
    }

    @Transactional
    public void deleteReceipe(String receipeId) throws ServiceException{
        FoodReceipe receipe = null;
        try{
            repository.deleteById(receipeId);
        }catch(Exception e){
            throw new ServiceException(receipe.getId(),e);
        }
    }

    private FoodReceipe translate(InputRequest request){
        FoodReceipe receipe = FoodReceipe.builder().id(CommonUtil.getUniqueId()).name(request.getName()).dish(request.getDish()).ingredient(request.getIngredient()).instruction(request.getInstruction())
                .lastUpdatedBy(request.getUserId()).lastUpdatedTime(LocalDate.now()).build();
        return receipe;
    }



}
