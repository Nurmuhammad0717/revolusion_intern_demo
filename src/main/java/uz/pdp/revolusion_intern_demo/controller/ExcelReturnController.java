
package uz.pdp.revolusion_intern_demo.controller;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.revolusion_intern_demo.entity.*;
import uz.pdp.revolusion_intern_demo.repository.*;
import uz.pdp.revolusion_intern_demo.utils.AppConstant;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping(AppConstant.BASE_PATH_V1+"/excel")
@RequiredArgsConstructor
public class ExcelReturnController {
    private UserRepository userRepository;
    private RoomRepository roomRepository;
    private RateRepository rateRepository;
    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;
    private HotelRepository hotelRepository;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<byte[]> exportUsersToExcel() {
        ByteArrayOutputStream outputStream = createUsersSheet();

        byte[] bytes = outputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.xlsx");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/rooms")
    public ResponseEntity<byte[]> exportRoomsToExcel() {
        ByteArrayOutputStream outputStream = createRoomsSheet();

        byte[] bytes = outputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=rooms.xlsx");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/rates")
    public ResponseEntity<byte[]> exportRatesToExcel() {
        ByteArrayOutputStream outputStream = createRatesSheet();

        byte[] bytes = outputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=rates.xlsx");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/payments")
    public ResponseEntity<byte[]> exportPaymentsToExcel() {
        ByteArrayOutputStream outputStream = createPaymentsSheet();

        byte[] bytes = outputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=payments.xlsx");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/orders")
    public ResponseEntity<byte[]> exportOrdersToExcel() {
        ByteArrayOutputStream outputStream = createOrdersSheet();

        byte[] bytes = outputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=orders.xlsx");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/hotels")
    public ResponseEntity<byte[]> exportHotelToExcel() {
        ByteArrayOutputStream outputStream = createHotelsSheet();

        byte[] bytes = outputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=hotels.xlsx");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    private ByteArrayOutputStream createUsersSheet() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Users");
        createHeader(sheet, new String[]{"ID", "Email", "Password", "Full Name", "Role", "Enabled"});

        List<User> users = userRepository.findAll();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            addRow(sheet, new String[]{
                    String.valueOf(user.getId()),
                    user.getEmail(),
                    user.getPassword(),
                    user.getFullName(),
                    user.getRole().name(),
                    String.valueOf(user.isEnabled())
            });
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            workbook.close();
            return outputStream;
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    private ByteArrayOutputStream createRoomsSheet() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Rooms");
        createHeader(sheet, new String[]{"ID", "Hotel Name", "Is Busy", "Room Type", "Room Number", "Price"});

        List<Room> rooms = roomRepository.findAll();
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            addRow(sheet, new String[]{
                    String.valueOf(room.getId()),
                    room.getHotel().getName(),
                    String.valueOf(room.getIsBusy()),
                    room.getRoomType().name(),
                    String.valueOf(room.getRoomNumber()),
                    String.valueOf(room.getPrice())
            });
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            workbook.close();
            return outputStream;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private ByteArrayOutputStream createRatesSheet() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Rates");
        createHeader(sheet, new String[]{"ID", "User Email", "Room Number", "Description", "Rate"});

        List<Rate> rates = rateRepository.findAll();
        for (int i = 0; i < rates.size(); i++) {
            Rate rate = rates.get(i);
            addRow(sheet, new String[]{
                    String.valueOf(rate.getId()),
                    rate.getUser().getEmail(),
                    String.valueOf(rate.getRoom().getRoomNumber()),
                    rate.getDescription(),
                    String.valueOf(rate.getRate())
            });
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            workbook.close();
            return outputStream;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private ByteArrayOutputStream createPaymentsSheet() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Payments");
        createHeader(sheet, new String[]{"ID", "Order ID", "Amount"});

        List<Payment> payments = paymentRepository.findAll();
        for (int i = 0; i < payments.size(); i++) {
            Payment payment = payments.get(i);
            addRow(sheet, new String[]{
                    String.valueOf(payment.getId()),
                    payment.getOrder() != null ? String.valueOf(payment.getOrder().getId()) : "N/A",
                    String.valueOf(payment.getAmount())
            });
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            workbook.close();
            return outputStream;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private ByteArrayOutputStream createOrdersSheet() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Orders");
        createHeader(sheet, new String[]{"ID", "User Email", "Room Number", "Start Date", "End Date", "Order Status", "Description"});

        List<Order> orders = orderRepository.findAll();
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            addRow(sheet, new String[]{
                    String.valueOf(order.getId()),
                    order.getUser().getEmail(),
                    String.valueOf(order.getRoom().getRoomNumber()),
                    order.getStartDate() != null ? order.getStartDate().toString() : "N/A",
                    order.getEndDate() != null ? order.getEndDate().toString() : "N/A",
                    order.getOrderStatus().name(),
                    order.getDescription()
            });
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            workbook.close();
            return outputStream;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private ByteArrayOutputStream createHotelsSheet() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Hotels");
        createHeader(sheet, new String[]{"ID", "Name", "Address", "Contact Number"});

        List<Hotel> hotels = hotelRepository.findAll();
        for (int i = 0; i < hotels.size(); i++) {
            Hotel hotel = hotels.get(i);
            addRow(sheet, new String[]{
                    String.valueOf(hotel.getId()),
                    hotel.getName(),
                    hotel.getAddress(),
                    hotel.getContactNumber()
            });
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            workbook.close();
            return outputStream;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    private void createHeader(Sheet sheet, String[] headers) {
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }
    }

    private void addRow(Sheet sheet, String[] data) {
        int rowNum = sheet.getPhysicalNumberOfRows();
        Row row = sheet.createRow(rowNum);
        for (int i = 0; i < data.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(data[i]);
        }
    }
}
