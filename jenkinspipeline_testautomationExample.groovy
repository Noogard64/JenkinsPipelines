pipeline{
	//enable time stamps in console log
	options{timestamps()}
	
	parameters{
			string(name:'exampleParameter', defaultValue:'exampleDefaultValue',description:'example default description')
	}
	
	//initiate job on master
	agent {label 'master'}
	
	stages{
		stage('execute tests'){
			
			//run all stage(s) in parallel
			parallel{
				
				stage('execute visual studio unit tests'){
					agent {label 'not master'} //need to verify syntax here
					steps{
						bat 'echo executing tests'
					}
				}
				stage('execute selenium tests'){
					agent {label 'not master'} //need to verify syntax here
					steps{
						bat 'echo executing tests'
					}
				}
				stage('execute ranorex tests'){
					agent {label 'not master'} //need to verify syntax here
					steps{
						bat '%WORKSPACE%\RanorexSolution\bin\Debug\RanorexSolution.exe'
					}
				}
				stage('execute SoapUI/Ready!API tests'){
					agent {label 'not master'} //need to verify syntax here
					steps{
						bat 'C:\ReadyAPI-1.9.0\bin\testrunner.bat -0 "-RProject Report" -FPDF "-EDefault environment" %WORKSPACE%'
					}
				}
				stage('execute postman tests'){
					agent {label 'not master'} //need to verify syntax here
					steps{
						sh '"%WORKSPACE%\newman Backup.postman_dump.json"'
					}
				}
				stage('execute example method'){
					agent {label 'not master'} //need to verify syntax here
					steps{
						exampleMethod()
					}						
				
				}

			}
		}
	}
}

def exampleMethod(){

bat 'echo do the method'	
	
}
			
				
				
				