module.exports.dateValidate = function (date) {
        var dateObj = new Date();
        var sysMonth = dateObj.getUTCMonth() + 1;
        var sysDay = dateObj.getUTCDate();
        var sysYear = dateObj.getUTCFullYear();
        var gd = date.split('-');
        var givenMonth = gd[0];
        var givenDay = gd[1];
        var givenYear = gd[2];
        sysMonth = parseInt(sysMonth);
        sysDay = parseInt(sysDay);
        sysYear = parseInt(sysYear);
        gienMonth = parseInt(givenMonth);
        givenDay = parseInt(givenDay);
        givenYear = parseInt(givenYear);
            
        if(parseInt(givenYear/1000) < 1){
            return false;
        }
        else{
            if(givenMonth > 12 || givenMonth < 1){
                return false;
            }
            else{
            if((givenMonth<8 && givenMonth%2 != 0) || (givenMonth>7 && givenMonth%2 == 0)){
                if(givenDay > 31 || givenDay<1){
                    return false;
                }
                
            }
            else{
                if(givenMonth == 2){
                    if(givenYear%400 != 0 && givenYear%100 == 0){
                        if(givenDay >28 || givenDay < 1){
                            return false;
                            
                        }
                    }
                    else if(givenYear%4 == 0){
                        if(givenDay >29 || givenDay < 1){
                            return false;
                            
                        }
                    }
                    else{
                        if(givenDay > 28 || givenDay<1){
                            return false;
                        }
                    }
                }
                else{
                    if(givenDay > 30 || givenDay < 1){
                        return false;
                    }
                }
            }
                
        }
            return true;
        }
}
module.exports.correctDate = function (date) {
        var dateObj = new Date();
        var sysMonth = dateObj.getUTCMonth() + 1;
        var sysDay = dateObj.getUTCDate();
        var sysYear = dateObj.getUTCFullYear();
        var gd = date.split('-');
        var givenMonth = gd[0];
        var givenDay = gd[1];
        var givenYear = gd[2];
        sysMonth = parseInt(sysMonth);
        sysDay = parseInt(sysDay);
        sysYear = parseInt(sysYear);
        gienMonth = parseInt(givenMonth);
        givenDay = parseInt(givenDay);
        givenYear = parseInt(givenYear);
            
        if(sysYear > givenYear){
            return false;
        }
        else if(sysYear == givenYear){
            if(sysMonth > givenMonth){
                return false;
            }
            else if(sysMonth == givenMonth){
                if(sysDay > givenDay){
                    return false;
                }
                else{
                    return true;
                }
            }
            else{
                return true;
            }
            
        }
    else return true;
        
}
module.exports.dobVal = function (date,dob) {
        var dateObj = dob.split('-');
        var sysMonth = dateObj[0];
        var sysDay = dateObj[1];
        var sysYear = dateObj[2];
        var gd = date.split('-');
        var givenMonth = gd[0];
        var givenDay = gd[1];
        var givenYear = gd[2];
        sysMonth = parseInt(sysMonth);
        sysDay = parseInt(sysDay);
        sysYear = parseInt(sysYear);
        gienMonth = parseInt(givenMonth);
        givenDay = parseInt(givenDay);
        givenYear = parseInt(givenYear);
           
        if(sysYear > givenYear){
            return false;
        }
        else if(sysYear == givenYear){
            if(sysMonth > givenMonth){
                return false;
            }
            else if(sysMonth == givenMonth){
                if(sysDay > givenDay){
                    return false;
                }
                else{
                    return true;
                }
            }
            else{
                return true;
            }
            
        }
    else return true;
        
}


