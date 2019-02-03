import com.amc.jenkinscommons.*
// instantiate


def call(Map args = [:]) {
    pl = new utilityFuncs()
    caughtError = 0
    ENV = args.get('environment') ?: 'dev'
    NODE = args.get('node') ?: ''
    IMAGE_NAME = args.get('image-name') ?: ''
    try {
        node (NODE) {
            stage('Init') {
                echo "Checking out code...${ENV}"
                pl.build()

            }
            // withCredentials([usernamePassword(credentialsId: 'nexus-service', passwordVariable: 'nexus_password', usernameVariable: 'nexus_username'), usernameColonPassword(credentialsId: 'nexus-service', variable: 'nexus_creds')]) {
            //     stage('Build') {
            //         // BUILD COMMANDS GET RUN HERE
            //         cmd = sh(script: "python3 -u ./jenkins/c_build.py '"+MANIFEST_JSON+"'", returnStdout: true)
            //         sh "export 'NEXUS_CREDS="+nexus_creds+"' 'NEXUS_PWD="+nexus_password+"' 'NEXUS_USR="+nexus_username+"'; "+cmd+""
            //     }
            // }

            // If we got here, it means the build was a success.
            currentBuild.result = "SUCCESS"

        }
    }
    catch(caughtError) {
            caughtError = caughtError
            echo caughtError.toString()
            currentBuild.result = "FAILURE"
    }
    finally {
        node {
              sh 'ls'
        }

        if (caughtError != 0) {
            throw caughtError
        }
    }
}
