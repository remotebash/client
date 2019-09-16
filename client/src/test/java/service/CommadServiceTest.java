package service;

import modal.Command;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class CommadServiceTest {

    CommandService commandService = new CommandService();

    @Test
    public void testIfMethod_SearchCommandToExecute_NotReturnNullPointer(){
        boolean error = false;

        try{
            commandService.searchCommandToExecute();
        }catch (NullPointerException nException){
            error = true;
        }

        assertEquals(false, error);
    }


}
