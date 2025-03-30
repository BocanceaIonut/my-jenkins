package service

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