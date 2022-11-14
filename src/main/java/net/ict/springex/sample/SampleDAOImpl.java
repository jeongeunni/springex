package net.ict.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("normal")
//@Primary
public class SampleDAOImpl implements SampleDAO {
}
