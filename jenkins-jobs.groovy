deliveryPipelineView('Application Pipeline') {
    pipelineInstances(5)
    showAggregatedPipeline()
    columns(1)
    updateInterval(60)
    enableManualTriggers()
    showAvatars()
    showChangeLog()
    
    pipelines {
        component('My Application', 'Build') {
            build('Build', 'Build')
            build('Test', 'Test')
            build('Staging', 'Staging')
            build('Production', 'Production')
        }
    }
} 