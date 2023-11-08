package com.tourbooking.service.booking.impl;

import com.tourbooking.model.booking.Booking;

public class Email {
    public static String sendContentEmail(Booking booking, String sumMoney){
        String content= "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "    <td style=\"margin:0;padding:0\">\n" +
                "        <table border=\"0\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" style=\"background-color:transparent;padding:0;margin:0 auto;max-width:650px;border-radius:8px\">\n" +
                "            <tbody>\n" +
                "            <tr>\n" +
                "                <td style=\"height:32px;line-height:32px\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "<!--            <tr style=\"text-align:center\">-->\n" +
                "<!--                <td style=\"padding:0;margin:0\">-->\n" +
                "<!--                    <img height=\"40\" role=\"img\" src=\"https://ci4.googleusercontent.com/proxy/NU9plaxKDoXxCQUHEsmryv61RYBMPiaiXfxVwLU3oArPecNo3kFkdD_4ByAyygAIpFy55DCFVgkerU-Z_Ieon7z4QQEd6Rt6qfvLA3XeHDy6ZEnhy1T31g0ywPtse3Q=s0-d-e1-ft#http://img.agoda.net/images/email/logo/agoda-logo-confirmation-footer@2x.png\" alt=\"Header logo\" aria-label=\"Header logo\">-->\n" +
                "<!--                </td>-->\n" +
                "<!--            </tr>-->\n" +
                "            <tr>\n" +
                "                <td style=\"height:32px;line-height:32px\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "    <td>\n" +
                "        <table border=\"0\" cellspacing=\"0\" align=\"center\" cellpadding=\"0\" style=\"border:1px solid #dddfe2;font-size:16px;border-top:6px solid #32a923;padding:0;margin:0 auto;max-width:650px;border-radius:8px;background-color:#ffffff;width:100%\" id=\"m_5737924533930551651m_-5597251490349479428confirmation-info-section\">\n" +
                "            <tbody>\n" +
                "            <tr>\n" +
                "                <td style=\"height:24px;line-height:24px;margin:0;padding:0\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr style=\"text-align:center\">\n" +
                "                <td>\n" +
                "                    <img height=\"42\" role=\"img\" src=\"https://ci3.googleusercontent.com/proxy/hBEmSpCNO6xZj9_SUlRWdCW5tjqPfrQsLkTjvrN7vjpsy6wH0qz3Jswqz_D6KvohXFt35dzY-4qpcJ71-I-qOgEFdQcJCwKbwBO0jqnNAhwknZCgg4FNalKbDwoxmJVwVbyNxL9bi-atMTdVbJ22penXWH8=s0-d-e1-ft#https://img.agoda.net/images/emailmarketing/spwl_agodatheme/confirmationinfo_circle_checkmark.png\" alt=\"booking success icon\" aria-label=\"booking success icon\">\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr style=\"text-align:center\">\n" +
                "                <td style=\"padding:0;padding-left:24px;padding-right:24px;padding-top:12px;font-size:20px;font-weight:bold;color:#32a923\">\n" +
                "                    <p style=\"margin:0;padding:0\">\n" +
                "                        Đơn đặt của quý khách hiện đã được xác nhận!\n" +
                "                    </p>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"height:32px;line-height:32px;margin:0;padding:0\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr style=\"text-align:center\">\n" +
                "                <td style=\"padding-left:24px;padding-right:24px\">\n" +
                "                    <p style=\"margin:0;padding:0\">Thân gửi "+booking.getName()+",</p>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"height:16px;line-height:16px;margin:0;padding:0\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "\n" +
                "            <tr>\n" +
                "                <td style=\"height:16px;line-height:16px;margin:0;padding:0\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr style=\"text-align:center\">\n" +
                "                <td>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"height:16px;line-height:16px\">&nbsp;</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"height:16px;line-height:16px;background-color:#f4f8fe\">\n" +
                "                    &nbsp;</td>\n" +
                "            </tr>\n" +
                "            <tr style=\"background-color:#f4f8fe\">\n" +
                "                <td style=\"padding-left:24px;padding-right:24px\">\n" +
                "                    <table border=\"0\" cellspacing=\"0\" align=\"center\" cellpadding=\"0\" style=\"font-size:16px;padding:0;margin:0 auto;max-width:650px;border-radius:8px;color:#737373\">\n" +
                "                        <tbody>\n" +
                "                        <tr style=\"text-align:center\">\n" +
                "                            <td style=\"padding-left:24px;padding-right:24px;font-size:12px\">\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        <tr style=\"text-align:center\">\n" +
                "                            <td style=\"padding-left:24px;padding-right:24px;font-size:12px\">\n" +
                "                                <p style=\"margin:0;padding:0\">\n" +
                "                                    Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi.\n" +
                "                                </p>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        </tbody>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"height:24px;line-height:24px;border-radius:0 0 8px 8px;background-color:#f4f8fe\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "    <td style=\"margin:0;padding:0;padding-top:16px\">\n" +
                "        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"font-size:16px;border:1px solid #dddfe2;padding:0;margin:0 auto;border-radius:8px;max-width:650px;background-color:#ffffff;width:100%\">\n" +
                "            <tbody>\n" +
                "            <tr>\n" +
                "                <td style=\"height:24px;line-height:24px;margin:0;padding:0\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"padding:0;Margin:0;padding-left:24px;padding-right:24px\">\n" +
                "                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"width:100%\">\n" +
                "                        <tbody>\n" +
                "                        <tr>\n" +
                "                            <td style=\"padding:0;Margin:0;padding-right:24px;border-right:1px solid #dddfe2;width:50%;vertical-align:top\">\n" +
                "                                <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                    <tbody>\n" +
                "                                    <tr>\n" +
                "                                        <td align=\"left\" style=\"padding:0;Margin:0;font-size:14px;color:#737373;text-align:left\">\n" +
                "                                            <p style=\"margin:0;padding:0\">\n" +
                "                                                Ngày bắt đầu\n" +
                "                                            </p>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    <tr>\n" +
                "                                        <td align=\"left\" style=\"padding:0;Margin:0;text-align:left;padding-top:8px\" id=\"m_5737924533930551651m_-5597251490349479428checkin-date\">\n" +
                "                                            <p style=\"margin:0;padding:0\">\n" +booking.getTour().getStartDate()+
                "                                            </p>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody>\n" +
                "                                </table>\n" +
                "                            </td>\n" +
                "                            <td style=\"padding:0;Margin:0;padding-left:24px;width:50%;vertical-align:top\">\n" +
                "                                <table align=\"right\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                    <tbody>\n" +
                "                                    <tr>\n" +
                "                                        <td align=\"right\" style=\"padding:0;Margin:0;font-size:14px;color:#737373;text-align:right\">\n" +
                "                                            <p style=\"margin:0;padding:0\">\n" +
                "                                                Ngày kết thúc\n" +
                "                                            </p>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    <tr>\n" +
                "                                        <td align=\"right\" style=\"padding:0;Margin:0;padding-top:8px;text-align:right\" id=\"m_5737924533930551651m_-5597251490349479428checkout-date\">\n" +
                "                                            <p style=\"margin:0;padding:0\">\n" +booking.getTour().getEndDate() +
                "                                            </p>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody>\n" +
                "                                </table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        </tbody>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"padding-left:24px;padding-right:24px\">\n" +
                "                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"width:100%\">\n" +
                "                        <tbody>\n" +
                "                        <tr>\n" +
                "                            <td style=\"margin:0;padding:0;border-bottom:1px solid #dddfe2;height:16px;line-height:16px\">\n" +
                "                                &nbsp;\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        </tbody>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"padding:0;padding-left:24px;padding-right:24px;padding-top:16px\">\n" +
                "                    <p style=\"margin:0;padding:0;font-size:14px\">\n" +
                "                        Quý khách cũng có thể dễ dàng tìm hiểu về các quy định và tiện nghi của chúng tôi tại <a style=\"text-decoration:underline;color:#488bf8\" href=\"\">Đơn đặt tour của tôi</a>\n" +
                "                    </p>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"padding:0;padding-left:24px;padding-right:24px;padding-top:16px\">\n" +
                "                    <p style=\"margin:0;padding:0;text-decoration:none;font-size:14px\">\n" +
                "                        Mọi câu hỏi liên quan đến tour, vui lòng liên hệ trực tiếp với chúng tôi.\n" +
                "                    </p>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td align=\"center\" style=\"padding:0;padding-left:24px;padding-right:24px;text-align:center;width:100%\">\n" +
                "                    <div style=\"display:inline-block;vertical-align:top;padding-left:8px;padding-right:8px\">\n" +
                "                        <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td>\n" +
                "                                    <table align=\"center cellpadding=\" cellspacing=\"0\">\n" +
                "                                        <tbody><tr>\n" +
                "                                            <td style=\"height:16px;line-height:16px;margin:0;padding:0\">\n" +
                "                                                &nbsp;\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        <tr style=\"background-color:#f4f8fe\">\n" +
                "                                            <td align=\"center\" style=\"margin:0;padding:0;width:248px;padding:16px;border-radius:4px\" id=\"m_5737924533930551651m_-5597251490349479428property-email\">\n" +
                "                                                <p style=\"margin:0;padding:0;text-align:center;display:inline\">\n" +
                "                                                    Thư điện tử: <a href=\"mailto:sangphth@gmail.com\" style=\"Margin:0;color:#5392f9;text-decoration:none\" target=\"_blank\">\n" +
                "                                                    vivu@gmail.com</a>\n" +
                "                                                </p>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody></table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </div>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"height:24px;line-height:24px;margin:0;padding:0\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "    <td style=\"padding:0;margin:0;padding-top:16px\">\n" +
                "        <table border=\"0\" cellspacing=\"0\" align=\"center\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;font-size:14px;color:#2a2a2e;border:1px solid #dddfe2;padding:0;margin:0 auto;max-width:650px;border-radius:8px;background-color:#ffffff\">\n" +
                "            <tbody>\n" +
                "            <tr>\n" +
                "                <td colspan=\"3\" style=\"padding:0;margin:0;padding-left:24px;padding-right:24px;padding-top:24px;font-weight:bold;font-size:18px;line-height:21px\">\n" +
                "                    Thông tin về Đơn đặt tour\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"1\" style=\"width:160px;padding:10px 18px 10px 24px;color:#737373;line-height:25px;vertical-align:top\">\n" +
                "                    Tên tour\n" +
                "                </td>\n" +
                "                <td colspan=\"2\" style=\"padding:10px 18px 10px 0;line-height:25px;color:#2a2a2e;vertical-align:top\" id=\"m_5737924533930551651m_-5597251490349479428booking-roomtype\">\n" +booking.getTour().getTourName()+
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"1\" style=\"width:160px;padding:10px 18px 10px 24px;color:#737373;line-height:25px;vertical-align:top\">\n" +
                "                    Số người ở\n" +
                "                </td>\n" +
                "                <td colspan=\"2\" style=\"padding:10px 18px 10px 0;line-height:25px;color:#2a2a2e;vertical-align:top\" id=\"m_5737924533930551651m_-5597251490349479428booking-occupancy\">\n" + booking.getAdultQuantity() + "người lớn\n" + + booking.getChildrenQuantity() + "trẻ em\n"+
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr style=\"border-collapse:collapse\">\n" +
                "                <td align=\"left\" style=\"padding:0 24px 0 24px;margin:0\" colspan=\"3\">\n" +
                "                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                        <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                            <td width=\"100%\" valign=\"top\" align=\"center\" style=\"padding:0;margin:0\">\n" +
                "                                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                                    <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                                        <td align=\"center\" style=\"padding:0;margin:0\">\n" +
                "                                            <table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                                                <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                                                    <td style=\"padding:0;Margin:0px 0px 0px 0px;border-bottom:1px solid #dddfe2;background:none;height:1px;width:100%;margin:0px\">\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                </tbody></table>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody></table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        </tbody></table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"1\" style=\"width:160px;padding:10px 18px 10px 24px;color:#737373;vertical-align:top;line-height:25px\">\n" +
                "                    Lợi ích\n" +
                "                </td>\n" +
                "                <td colspan=\"2\" style=\"padding:10px 18px 10px 0;line-height:25px;color:#32a923;vertical-align:top\" id=\"m_5737924533930551651m_-5597251490349479428booking-benefits\">\n" +
                "                    <div>\n" +
                "                        Wi-Fi, Bãi đậu xe, Nhận phòng nhanh, WiFi miễn phí\n" +
                "                    </div>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr style=\"border-collapse:collapse\">\n" +
                "                <td align=\"left\" style=\"padding:0 24px 0 24px;margin:0\" colspan=\"3\">\n" +
                "                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                        <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                            <td width=\"100%\" valign=\"top\" align=\"center\" style=\"padding:0;margin:0\">\n" +
                "                                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                                    <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                                        <td align=\"center\" style=\"padding:0;margin:0\">\n" +
                "                                            <table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                                                <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                                                    <td style=\"padding:0;Margin:0px 0px 0px 0px;border-bottom:1px solid #dddfe2;background:none;height:1px;width:100%;margin:0px\">\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                </tbody></table>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody></table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        </tbody></table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"1\" style=\"width:160px;padding:10px 18px 10px 24px;color:#737373;line-height:25px;vertical-align:top\">\n" +
                "                    Yêu cầu đặc biệt\n" +
                "                </td>\n" +
                "                <td colspan=\"2\" style=\"padding:10px 18px 10px 0;line-height:25px;color:#2a2a2e;vertical-align:top\" id=\"m_5737924533930551651m_-5597251490349479428booking-specialrequest\">\n" +
                "                    I'd like a non-smoking room\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"3\" style=\"color:#737373;line-height:20px;padding:0;padding-left:24px;padding-bottom:24px\">\n" +
                "                    Mọi yêu cầu đặc biệt đều lệ thuộc vào khả năng cung cấp khi đến.\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr style=\"border-collapse:collapse\">\n" +
                "                <td align=\"left\" style=\"padding:0 24px 0 24px;margin:0\" colspan=\"3\">\n" +
                "                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                        <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                            <td width=\"100%\" valign=\"top\" align=\"center\" style=\"padding:0;margin:0\">\n" +
                "                                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                                    <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                                        <td align=\"center\" style=\"padding:0;margin:0\">\n" +
                "                                            <table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                                                <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                                                    <td style=\"padding:0;Margin:0px 0px 0px 0px;border-bottom:1px solid #dddfe2;background:none;height:1px;width:100%;margin:0px\">\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                </tbody></table>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody></table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        </tbody></table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "    <td style=\"padding:0;margin:0;padding-top:16px\">\n" +
                "        <table border=\"0\" cellspacing=\"0\" align=\"center\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;font-size:14px;color:#2a2a2e;border:1px solid #dddfe2;padding:0;margin:0 auto;max-width:650px;border-radius:8px;background-color:#ffffff\">\n" +
                "            <tbody>\n" +
                "            <tr>\n" +
                "                <td colspan=\"2\" style=\"padding:24px 24px 16px 24px;font-weight:bold;font-size:18px;line-height:21px\" id=\"m_5737924533930551651m_-5597251490349479428payment-title\">\n" +
                "                    Đặt phòng của bạn đã được xác nhận\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr style=\"border-collapse:collapse\">\n" +
                "                <td align=\"left\" style=\"padding:0 24px 10px 24px;margin:0\" colspan=\"2\">\n" +
                "                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                        <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                            <td width=\"100%\" valign=\"top\" align=\"center\" style=\"padding:0;margin:0\">\n" +
                "                                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                                    <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                                        <td align=\"center\" style=\"padding:0;margin:0\">\n" +
                "                                            <table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                                                <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                                                    <td style=\"padding:0;Margin:0px 0px 0px 0px;border-bottom:1px solid #dddfe2;background:none;height:1px;width:100%;margin:0px\">\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                </tbody></table>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody></table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        </tbody></table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"padding:0 18px 0 24px;color:#737373;line-height:25px;vertical-align:top;font-weight:bold\">\n" +
                "                    Tổng Tiền\n" +
                "                </td>\n" +
                "                <td style=\"padding:0 24px 0 0;line-height:25px;color:#2a2a2e;vertical-align:top;font-weight:bold;text-align:right\" id=\"m_5737924533930551651m_-5597251490349479428payment-totalcharge-amount\">\n" +
                "                   "+sumMoney+"\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"2\" style=\"margin:0;padding:0;padding-top:6px;padding-left:24px;padding-right:24px;color:#737373;font-size:12px\" id=\"\">\n" +
                "                    Bao gồm : Thuế và phí"+sumMoney+
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "<!--                <td colspan=\"2\" style=\"margin:0;padding:0;padding-top:6px;padding-left:24px;padding-right:24px;color:#737373;font-size:12px\" id=\"\">-->\n" +
                "<!--                </td>-->\n" +
                "            </tr>\n" +
                "\n" +
                "            <tr>\n" +
                "                <td style=\"padding:0;margin:0;line-height:24px\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </td>\n" +
                "</tr>\n" +
                "<tr id=\"m_5737924533930551651m_-5597251490349479428download-app-b\">\n" +
                "    <td style=\"padding:0;margin:0;padding-top:16px\">\n" +
                "        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" width=\"100%\" style=\"max-width:650px;margin:0 auto;border:1px solid #dddfe2;border-radius:8px;background:#dde9fd;overflow:hidden\">\n" +
                "            <tbody>\n" +
                "            <tr>\n" +
                "                <td style=\"background:url();background-size:46% auto;background-position:bottom right;background-repeat:no-repeat\">\n" +
                "\n" +
                "                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"font-size:14px;color:#2a2a2e;padding:24px\">\n" +
                "                        <tbody>\n" +
                "                        <tr>\n" +
                "                            <td style=\"padding-bottom:24px;font-weight:bold;font-size:18px;line-height:21px\">\n" +
                "                                Tải ứng dụng được trao giải thưởng của chúng tôi để mở khóa giá rẻ hơn!\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        <tr>\n" +
                "                            <td style=\"padding-bottom:4px\">\n" +
                "                                <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                    <tbody>\n" +
                "                                    <tr>\n" +
                "                                        <td width=\"20\" style=\"vertical-align:top\">\n" +
                "                                            <img src=\"https://ci4.googleusercontent.com/proxy/4pTIgfWjBuHkyPvypmF_-RPN26vlEadgsy13-xDi_vASo6eHc5s32K6SMcQYKwbd6aEutuJeHCrrKytbUNk01IOwck6lKkI4IOzDapCl0QveOlUaUeRkvppk2SQapvPEPXHhTv2Gdp-tMt8=s0-d-e1-ft#https://cdn6.agoda.net/images/email/booking-confirmation/default/loy-6326/icon-check.png\" alt=\"check icon\" width=\"12\" style=\"margin-top:3px\">\n" +
                "                                        </td>\n" +
                "                                        <td style=\"vertical-align:top\">\n" +
                "                                            <div>Quản lý Đặt chỗ Dễ dàng</div>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody>\n" +
                "                                </table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        <tr>\n" +
                "                            <td>\n" +
                "                                <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                    <tbody>\n" +
                "                                    <tr>\n" +
                "                                        <td width=\"20\" style=\"vertical-align:top\">\n" +
                "                                            <img src=\"https://ci4.googleusercontent.com/proxy/4pTIgfWjBuHkyPvypmF_-RPN26vlEadgsy13-xDi_vASo6eHc5s32K6SMcQYKwbd6aEutuJeHCrrKytbUNk01IOwck6lKkI4IOzDapCl0QveOlUaUeRkvppk2SQapvPEPXHhTv2Gdp-tMt8=s0-d-e1-ft#https://cdn6.agoda.net/images/email/booking-confirmation/default/loy-6326/icon-check.png\" alt=\"check icon\" width=\"12\" style=\"margin-top:3px\">\n" +
                "                                        </td>\n" +
                "                                        <td style=\"vertical-align:top\">\n" +
                "                                            <div>Tiếp cận các ưu đãi dành riêng cho ứng dụng</div>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody>\n" +
                "                                </table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        <tr>\n" +
                "                            <td style=\"padding-top:70px\">\n" +
                "                                <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"padding:0;margin:0\">\n" +
                "                                    <tbody>\n" +
                "                                    <tr>\n" +
                "                                        <td id=\"m_5737924533930551651m_-5597251490349479428download-app-stores\" width=\"145\" style=\"padding-right:24px\">\n" +
                "                                            <div style=\"width:145px;height:43px;margin-bottom:12px\">\n" +
                "                                                <a href=\"e\" style=\"font-family:helvetica,'helvetica neue',arial,verdana,sans-serif;font-size:18px;text-decoration:underline;color:#5392f9;display:inline-block;width:145px;height:43px\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?hl=vi&amp;q=https://agoda.onelink.me/1640755593?af_dp%3Dagoda%253A%252F%252Fmmb?bookingToken%3Dsometoken%26deep_link_value%3Dagoda%253A%252F%252Fmmb%26af_click_lookback%3D1d%26pid%3DRedirect%26c%3DEmailQRCode%26af_siteid%3D1746555%26site_id%3D1746555%26af_sub5%3D1746555%26af_force_deeplink%3Dtrue&amp;source=gmail&amp;ust=1699444640958000&amp;usg=AOvVaw22ar0dU3oyMUyGxjCd2afR\">\n" +
                "                                                    <img src=\"https://ci6.googleusercontent.com/proxy/9N4vYXcxs4fDs1fUA0MFfPGAJtKZ-xic6wGLFRByqgHmVpGZIc93o8o3URq3-KUugno2j4Lcd0jf95grcV0cYibKdKsATkNY8Kgo4bsc1CMZTYOk3PyOv919msjg-TyqNjXxYds-cNMFLW3AK3ww6Q=s0-d-e1-ft#https://cdn6.agoda.net/images/email/booking-confirmation/default/loy-6326/app-store-badge.png\" alt=\"Download on the App Store\" style=\"border:0;outline:none;text-decoration:none\" width=\"145\" height=\"43\">\n" +
                "                                                </a>\n" +
                "                                            </div>\n" +
                "                                            <div style=\"width:145px;height:43px\">\n" +
                "                                                <a href=\"\" style=\"font-family:helvetica;'helvetica neue',arial,verdana,sans-serif;font-size:18px;text-decoration:underline;color:#5392f9;display:inline-block;width:145px;height:43px\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?hl=vi&amp;q=https://agoda.onelink.me/1640755593?af_dp%3Dagoda%253A%252F%252Fmmb?bookingToken%3Dsometoken%26deep_link_value%3Dagoda%253A%252F%252Fmmb%26af_click_lookback%3D1d%26pid%3DRedirect%26c%3DEmailQRCode%26af_siteid%3D1746555%26site_id%3D1746555%26af_sub5%3D1746555%26af_force_deeplink%3Dtrue&amp;source=gmail&amp;ust=1699444640958000&amp;usg=AOvVaw22ar0dU3oyMUyGxjCd2afR\">\n" +
                "                                                    <img src=\"https://ci3.googleusercontent.com/proxy/XKEudEl4lmuZBnUWMr4h7kplpY2iYvbD6rAjHvpK6sS6CvIFs2X2xs4csjZuQHrpTQ4rsoZyfnNP20kbFmHdNtHC46UB3I2DP2Oen6lGXKhqzlU4P9wFws48lUUjbf1luxriknXcLI3mYB3CzfAkedpt=s0-d-e1-ft#https://cdn6.agoda.net/images/email/booking-confirmation/default/loy-6326/google-play-badge.png\" alt=\"GET IT ON Google Play\" style=\"border:0;outline:none;text-decoration:none\" width=\"145\" height=\"43\">\n" +
                "                                                </a>\n" +
                "                                            </div>\n" +
                "                                            <p style=\"font-size:12px;line-height:20px;text-align:center;margin:4px 0 0\">\n" +
                "                                                Tải ứng dụng về\n" +
                "                                            </p>\n" +
                "                                        </td>\n" +
                "                                        <td width=\"97\">\n" +
                "                                            <div style=\"width:97px;height:97px\">\n" +
                "                                                <a href=\"\" style=\"font-family:helvetica,'helvetica neue',arial,verdana,sans-serif;font-size:18px;text-decoration:underline;color:#5392f9;display:inline-block;width:97px;height:97px\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?hl=vi&amp;q=https://agoda.onelink.me/1640755593?af_dp%3Dagoda%253A%252F%252Fmmb?bookingToken%3Dsometoken%26deep_link_value%3Dagoda%253A%252F%252Fmmb%26af_click_lookback%3D1d%26pid%3DRedirect%26c%3DEmailQRCode%26af_siteid%3D1746555%26site_id%3D1746555%26af_sub5%3D1746555%26af_force_deeplink%3Dtrue&amp;source=gmail&amp;ust=1699444640958000&amp;usg=AOvVaw22ar0dU3oyMUyGxjCd2afR\">\n" +
                "                                                    <img src=\"https://ci3.googleusercontent.com/proxy/AFNW_OWx08ypGcKHHm4QQu8wLvblRNQyxgAF46SSlgFvyFtEaHUl6HycxgwBIyHQBMaNr-vFjo2kYwtlkAhR5XBZXsPHWTOpWIUylHRUTHluHBmB6npTUkj18yU3BYYgGEAU1KyC5IcQCWTPTTWEMP-iK6YP3Y0bHNiH-Q=s0-d-e1-ft#https://cdn6.agoda.net/images/email/booking-confirmation/default/loy-6326/download-app-qr-code-global.png\" style=\"display:block;border:0;outline:none;text-decoration:none\" width=\"97\" height=\"97\">\n" +
                "                                                </a>\n" +
                "                                            </div>\n" +
                "                                            <p style=\"font-size:12px;line-height:20px;text-align:center;margin:4px 0 0\">\n" +
                "                                                Quét QR\n" +
                "                                            </p>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody>\n" +
                "                                </table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        </tbody>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "    <td style=\"padding:0;margin:0;padding-top:16px\">\n" +
                "        <table border=\"0\" cellspacing=\"0\" align=\"center\" cellpadding=\"0\" width=\"100%\" style=\"font-size:14px;color:#2a2a2e;border:1px solid #dddfe2;padding:0;margin:0 auto;max-width:650px;border-radius:8px;background-color:#ffffff\">\n" +
                "\n" +
                "            <tr style=\"text-align:center\">\n" +
                "                <td style=\"color:#666666;font-size:12px;line-height:19px;padding-top:36px\">\n" +
                "                    <p style=\"margin:0\">Đây là thư một chiều. Vui lòng không trả lời thư này.</p>\n" +
                "                    <p style=\"margin:0;padding-top:8px;color:#666666\">Chúng tôi đã thông báo cho công ty về đặt chỗ sắp tới của quý khách. Chúc quý khách có một chuyến đi vui vẻ.</p>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr style=\"text-align: center; border-collapse:collapse\">\n" +
                "                <td align=\"center\" style=\"padding:12px 0 0 0;margin:0 auto;max-width:650px\">\n" +
                "                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;border-spacing:0px;width:100%;max-width:650px;margin:0 auto\">\n" +
                "                        <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                            <td width=\"100%\" valign=\"top\" align=\"center\" style=\"padding:0;margin:0\">\n" +
                "                                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                                    <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                                        <td align=\"center\" style=\"padding:0;margin:0\">\n" +
                "                                            <table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px\">\n" +
                "                                                <tbody><tr style=\"border-collapse:collapse\">\n" +
                "                                                    <td style=\"padding:0;Margin:0px 0px 0px 0px;border-bottom:2px solid #dddfe2;border-bottom:2px solid rgba(99,101,247,0.166837);background:none;height:1px;width:100%;margin:0px\">\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                </tbody></table>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    </tbody></table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        </tbody>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr style=\"text-align:center\">\n" +
                "                <td style=\"color:#999999;font-size:12px;line-height:19px;padding-top:12px\">\n" +
                "                    <p style=\"margin:0\">Email này được gởi bởi: VIVU Company Pte. Ltd., Hai Chau, Da Nang</p>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"padding:0;margin:0;line-height:36px\">\n" +
                "                    &nbsp;\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "    </td>\n" +
                "</tr>\n" +
                "\n" +
                "</tbody>\n" +
                "</body>\n" +
                "</html>";
        return content;
    }
}
