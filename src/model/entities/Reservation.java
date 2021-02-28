package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out não pode ser inferior a data de check-in!");
			
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public Long duration() {
		
		Long qtdDias = checkOut.getTime() - checkIn.getTime();
		
		return TimeUnit.DAYS.convert(qtdDias, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if(checkIn.before(now)||checkOut.before(now)) {
			throw new DomainException("Verifique a data digitada, permito atualizar somente para Datas futuras!");
			
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out não pode ser inferior a data de agora!");
			
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {
		return 
	"Reservation: Room " 
	+ roomNumber 
	+ ", check-in: " 
	+ sdf.format(checkIn)  
	+ ", check-out: " 
	+ sdf.format(checkOut) 
	+", "
	+duration()
	+ " nights";
	}
	

	

}
