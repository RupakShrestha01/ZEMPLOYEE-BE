package zemployee

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import groovy.transform.CompileStatic

@SuppressWarnings('GrailsStatelessService')
@CompileStatic
class UploadPointOfInterestFeaturedImageService implements GrailsConfigurationAware {

    EmployeeService employeeService

    String cdnFolder
    String cdnRootUrl

    @Override
    void setConfiguration(Config co) {
        cdnFolder = co.getRequiredProperty('grails.guides.cdnFolder')
        cdnRootUrl = co.getRequiredProperty('grails.guides.cdnRootUrl')
    }

    @SuppressWarnings('JavaIoPackageAccess')
    Employee uploadFeatureImage(FeaturedImageCommand cmd) {

        String filename = cmd.featuredImageFile.originalFilename
        String folderPath = "${cdnFolder}/pointOfInterest/${cmd.id}"
        File folder = new File(folderPath)
        if ( !folder.exists() ) {
            folder.mkdirs()
        }
        String path = "${folderPath}/${filename}"
        cmd.featuredImageFile.transferTo(new File(path))

        String featuredImageUrl = "${cdnRootUrl}/employee/viewImage?fileName=${filename}"
        Employee poi = employeeService.updateFeaturedImageUrl(cmd.id, cmd.version, featuredImageUrl)

        if ( !poi || poi.hasErrors() ) {
            File f = new File(path)
            f.delete()
        }
        poi
    }
}