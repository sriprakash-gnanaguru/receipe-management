package com.food.receipe.manage.adapter.in.http;

import com.food.receipe.manage.adapter.out.http.OutputResponse;
import com.food.receipe.manage.common.BusinessException;
import com.food.receipe.manage.common.FoodReceipeManagementService;
import com.food.receipe.manage.common.ServiceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class FoodReceipeManagementController implements FoodReceipeManagementApi {

    @Autowired
    FoodReceipeManagementService service;

    @Override
    public OutputResponse addReceipe(InputRequest request) throws BusinessException {
        try{
            service.addReceipe(request);
        }catch (Exception e){
            throw new BusinessException(request.getReceipeId() ,e);
        }
        return OutputResponse.builder().receipeId(request.getReceipeId()).status("Success").msg("Receipe persisted successfully").build();
    }

    @Override
    public OutputResponse deleteReceipe(String receipeId) throws BusinessException {
        try{
            service.deleteReceipe(receipeId);
        }catch (Exception e){
            throw new BusinessException(receipeId ,e);
        }
        return OutputResponse.builder().receipeId(receipeId).status("Success").msg("Receipe deleted successfully").build();
    }

}
