/**
 * 2011 Foxykeep (http://datadroid.foxykeep.com)
 * <p>
 * Licensed under the Beerware License : <br />
 * As long as you retain this notice you can do whatever you want with this stuff. If we meet some
 * day, and you think this stuff is worth it, you can buy me a beer in return
 */

package external.GifImageViewEx.net.frakbot.imageviewex.service;

import external.GifImageViewEx.com.foxykeep.datadroid.exception.CustomRequestException;
import external.GifImageViewEx.com.foxykeep.datadroid.requestmanager.Request;
import external.GifImageViewEx.com.foxykeep.datadroid.service.RequestService;
import external.GifImageViewEx.net.frakbot.imageviewex.ImageViewNext;
import external.GifImageViewEx.net.frakbot.imageviewex.operation.ImageDiskCacheOperation;
import external.GifImageViewEx.net.frakbot.imageviewex.operation.ImageDownloadOperation;
import external.GifImageViewEx.net.frakbot.imageviewex.operation.ImageMemCacheOperation;
import external.GifImageViewEx.net.frakbot.imageviewex.requestmanager.ImageViewExRequestFactory;
import android.os.Bundle;

/**
 * This class is called by the {@link ImageViewExRequestManager} through the
 * {@link Intent} system.
 * 
 * @author Foxykeep, Francesco Pontillo
 */
@SuppressWarnings("deprecation")
public class ImageViewExService extends RequestService {

    @Override
    protected int getMaximumNumberOfThreads() {
        return ImageViewNext.getMaximumNumberOfThreads();
    }

    @Override
    public Operation getOperationForType(int requestType) {
        switch (requestType) {
            case ImageViewExRequestFactory.REQUEST_TYPE_IMAGE_MEM_CACHE:
                return new ImageMemCacheOperation();
            case ImageViewExRequestFactory.REQUEST_TYPE_IMAGE_DISK_CACHE:
                return new ImageDiskCacheOperation();
            case ImageViewExRequestFactory.REQUEST_TYPE_IMAGE_DOWNLOAD:
                return new ImageDownloadOperation();
        }
        return null;
    }

    @Override
    protected Bundle onCustomRequestException(Request request,
            CustomRequestException exception) {
        return super.onCustomRequestException(request, exception);
    }

}
