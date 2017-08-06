package ua.epam.training.task3.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Transport {
    private final static String FIRST_COLUMN = "Название";
    private final static String SECOND_COLUMN = "Описание";
    private final static String THIRD_COLUMN = "Начало";
    private final static String FOURTH_COLUMN = "Конец";
    private final static String FIFTH_COLUMN = "Стоимость";
    private int nameWidth = FIRST_COLUMN.length();
    private int descriptionWidth = SECOND_COLUMN.length();
    private DateFormat format = new SimpleDateFormat("HH:mm");
    private Route routes[];

    Route[] getRoutes() {
        return routes;
    }

    Transport() throws IOException, ParseException {
        System.out.println("Введите количество маршрутов:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int routesCount = Integer.parseInt(reader.readLine());
        routes = new Route[routesCount];
        for (int routeNumber = 0; routeNumber < routesCount; routeNumber++) {
            Route route = new Route();
            String name = getName(reader, routeNumber);
            route.setName(name);
            route.setDescription(getDescription(reader, name));
            final Date beginWork = getRouteStart(reader, name);
            route.setBeginWork(beginWork);
            route.setEndWork(getRouteStop(reader, name, beginWork));
            route.setPrice(getCost(reader, name));
            routes[routeNumber] = route;
        }
    }

    private String getName(BufferedReader reader, int routeNumber) throws IOException {
        boolean hasDuplicate = false;
        String name = "";
        while (!hasDuplicate) {
            System.out.println("Введите название маршрута №" + (routeNumber + 1) + ":");
            name = reader.readLine();
            hasDuplicate = true;
            for (int j = 0; j < routeNumber; j++) {
                if (name.equals(routes[j].getName())) {
                    hasDuplicate = false;
                    break;
                }
            }
        }
        return name;
    }

    private String getDescription(BufferedReader reader, String name) throws IOException {
        System.out.println("Введите описание маршрута " + name + ":");
        return reader.readLine();
    }

    private Date getRouteStart(BufferedReader reader, String name) throws IOException, ParseException {
        System.out.println("Введите время начала маршрута " + name + " в формате HH:mm:");
        return format.parse(reader.readLine());
    }

    private Date getRouteStop(BufferedReader reader, String name, Date beginWork) throws IOException, ParseException {
        System.out.println("Введите время конца маршрута " + name + " в формате HH:mm:");
        Date endWork = format.parse(reader.readLine());
        while (beginWork.compareTo(endWork) >= 0) {
            System.out.println("Время конца маршрута должно быть больше времени начала");
            System.out.println("Введите время конца маршрута " + name + " в формате HH:mm:");
            endWork = format.parse(reader.readLine());
        }
        return endWork;
    }

    private BigDecimal getCost(BufferedReader reader, String name) throws IOException {
        BigDecimal cost;
        while (true) {
            System.out.println("Введите стоимость проезда маршрутом " + name + ":");
            try {
                cost = new BigDecimal(reader.readLine());
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return cost;
    }

    Route[] searchRoutes(String searchString) {
        Boolean[] booleans = new Boolean[routes.length];
        int foundCount = 0;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i].getName().contains(searchString) || routes[i].getDescription().contains(searchString)) {
                booleans[i] = true;
                foundCount++;
            } else {
                booleans[i] = false;
            }
        }
        Route[] resultRoutes = new Route[foundCount];
        for (int i = routes.length - 1; i >= 0; i--) {
            if (booleans[i]) {
                resultRoutes[--foundCount] = routes[i];
            }
        }
        return resultRoutes;
    }

    void printRoutes(Route[] routes) {
        if (routes.length == 0) {
            System.out.println("Нет данных для вывода");
        } else {
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < nameWidth - FIRST_COLUMN.length(); i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(FIRST_COLUMN);
            for (int i = 0; i <= descriptionWidth - SECOND_COLUMN.length(); i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(SECOND_COLUMN);
            stringBuilder.append(" ");
            stringBuilder.append(THIRD_COLUMN);
            stringBuilder.append(" ");
            stringBuilder.append(FOURTH_COLUMN);
            stringBuilder.append(" ");
            stringBuilder.append(FIFTH_COLUMN);
            System.out.println(stringBuilder.toString());
            for (Transport.Route route : routes) {
                System.out.println(route);
            }
        }
    }

    class Route {
        private String name;
        private String description;
        private BigDecimal price;
        private Date beginWork;
        private Date endWork;

        String getBeginWork() {
            return format.format(beginWork);
        }

        void setBeginWork(Date beginWork) throws ParseException {
            this.beginWork = beginWork;
        }

        String getEndWork() {
            return format.format(endWork);
        }

        void setEndWork(Date endWork) throws ParseException {
            this.endWork = endWork;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
            nameWidth = Math.max(name.length(), nameWidth);
        }

        String getDescription() {
            return description;
        }

        void setDescription(String description) {
            this.description = description;
            descriptionWidth = Math.max(description.length(), descriptionWidth);
        }

        BigDecimal getPrice() {
            return price;
        }

        void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < nameWidth - name.length(); i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(name);
            for (int i = 0; i <= descriptionWidth - description.length(); i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(getDescription());
            stringBuilder.append("  ");
            stringBuilder.append(getBeginWork());
            stringBuilder.append(" ");
            stringBuilder.append(getEndWork());
            stringBuilder.append(" ");
            stringBuilder.append(getPrice());
            return stringBuilder.toString();
        }
    }
}
