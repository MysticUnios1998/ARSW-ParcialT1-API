package eci.arsw.covidanalyzer;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidAggregateController {
	
	@Autowired
	@Qualifier("CovidAggregateService")
    ICovidAggregateService covidAggregateService;

    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.POST)
    public ResponseEntity<?> addTruePositiveResult(Result result) {
        //TODO
    	try {
	        covidAggregateService.aggregateResult(result, ResultType.TRUE_POSITIVE);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    } catch (Exception e){
	        return new ResponseEntity<>("ERROR 500",HttpStatus.INTERNAL_SERVER_ERROR);
	    }

    }


    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.GET)
    public ResponseEntity<?> getTruePositiveResult() {
    	 try{
             return new ResponseEntity<>(covidAggregateService.getResult(ResultType.TRUE_POSITIVE), HttpStatus.ACCEPTED);
         }catch (Exception e){
             return new ResponseEntity<>("ERROR 500",HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
    
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.POST)
    public ResponseEntity<?> addFalsePositiveResult(Result result){
    	try {
	        covidAggregateService.aggregateResult(result, ResultType.FALSE_POSITIVE);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    } catch (Exception e){
	        return new ResponseEntity<>("ERROR 500",HttpStatus.INTERNAL_SERVER_ERROR);
	    }
    }
    
    
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.GET)
    public ResponseEntity<?> getFalsePositiveResult(){
    	try{
            return new ResponseEntity<>(covidAggregateService.getResult(ResultType.FALSE_POSITIVE), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("ERROR 500",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/covid/result/persona/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> savePersonaWithMultipleTests() {
        covidAggregateService.getResult(ResultType.TRUE_POSITIVE);
        try {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
}