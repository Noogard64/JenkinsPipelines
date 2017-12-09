pipeline{
    options{timestamps()}
    agent{label master}
    stages{
        stage('read data from text file'){
            
			steps{
				//script{
					def words = []
					new File('C:\\Users\\Sean\\Desktop\\textFile.txt') eachline{ line -> words << line}
					
					words.each{
						bat 'echo '& it
					}
				//}
			}
        }
    }

}