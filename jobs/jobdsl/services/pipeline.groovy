import javaposse.jobdsl.dsl.DslFactory

class MyPipeline {
    private DslFactory dslFactory
    
    MyPipeline(DslFactory dslFactory) {
        this.dslFactory = dslFactory
    }
    
    def build = dslFactory.pipelineJob('my-pipeline-build') {
        definition {
            cps {
                script('''
                    pipeline {
                        agent any
                        stages {
                            stage('Build') {
                                steps {
                                    echo 'Building..'
                                }
                            }
                            stage('Test') {
                                steps {
                                    echo 'Testing..'
                                }
                            }
                            stage('Deploy to Staging') {
                                steps {
                                    echo 'Deploying to staging..'
                                }
                            }
                            stage('Deploy to Production') {
                                steps {
                                    echo 'Deploying to production..'
                                }
                            }
                        }
                    }
                ''')
            }
        }
    }
} 

deliveryPipelineView("My Application Pipeline") {
    pipelineInstances(5)
    showAggregatedPipeline()
    columns(1)
    updateInterval(60)
    enableManualTriggers()
    showAvatars()
    showChangeLog()
    pipelines {
        component("My Application", new MyPipeline(this as DslFactory).build.getName())
    }
} 