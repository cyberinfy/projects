
module.exports.checkD = function (event) {
  var assert = require('assert');
    var mongoose = require('mongoose');
	var MongoClient = require('mongodb').MongoClient;
	mongoose.connect('mongodb://localhost:27017/donors');
    var resp = require('./resp');
    var dv = require('./dv');
    var obj = require('./donor');
    var obj1 = require('./requestor');
    var fb = require('./fbs');
    var sender1 = event.sender.id;
    let text = event.message.text;
    var sr = JSON.stringify(text);
    var Promise = require('promise');
var m=0;
   var jsonPromise = new Promise(function(resolve, reject){
   
    obj.find({
        "id": sender1
    }, (err, data) => {
        if (err) {
            console.error(err);
        } else {
        	var count=0;
            data.forEach(don => {
                if (don.gender !== sender1 && don.dob === sender1) {
                	
                    var str = sr.substring(1, sr.length - 1);
                    if (dv.dateValidate(str) === false) {
                        
                        fb.send(sender1, 'Please enter a valid date (mm-dd-yyyy)');
                        count=1;
                        return false;
                     } 
                    
                } else if (don.bloodgroup !== sender1 && don.date === sender1) {
                    var str = sr.substring(1, sr.length - 1);
                    if (dv.dateValidate(str) === false || dv.dobVal(str,don.dob) === false) {
                        
                        fb.send(sender1, 'Please enter a valid date (mm-dd-yyyy)');
                        count = 1;
                        return false;
                       
                       

                    }
                    
                    
                     
                }


            });
            
            // console.log('count:'+count);
            m=count;
            
        }

    })
      


    obj1.find({
        "id": sender1
    }, (err, data) => {
        if (err) {
            console.error(err);
        } else {
        	var count = 0;
            data.forEach(req => {
                if (req.name !== sender1 && req.date === sender1) {
                    var str = sr.substring(1, sr.length - 1);
                    if (dv.dateValidate(str) === false || dv.correctDate(str) === false) {
                        fb.send(sender1, 'Please enter a valid date (mm-dd-yyyy)');
                        count = 1;
                        return false;
                        

                    }



                }
            })
//            console.log('count:'+count);
             
            	if(m==0)
            	{
            		m=count;
            		
        }
        
       if(m==0){
        	resolve();

        }
        
    }




    })
console.log('in m : '+m);	

});
   jsonPromise.then(function (){
 
   console.log('m in function2:-'+m)
  if(m==0)
  resp.sendMessage(event);

});

jsonPromise.catch((error) => {
  
  done();
});
}

